package com.znb.javalib

import com.google.gson.Gson
import org.apache.commons.logging.Log
import org.apache.http.Consts
import org.apache.http.Consts.UTF_8
import org.apache.http.HttpResponse
import org.apache.http.client.methods.HttpPost
import org.apache.http.entity.ContentType
import org.apache.http.entity.mime.MultipartEntityBuilder
import org.apache.http.impl.client.HttpClients
import org.apache.http.util.EntityUtils
import java.io.File
import java.io.IOException
import java.security.MessageDigest
import java.util.*
import java.util.concurrent.TimeUnit


object CertSign {
    var API_KEY = "028e184bb9e111ea9db6fa163e50f325"
    var nonce = ""
    var timestamp = ""
    var sign = ""
    val myTag = "CertSign"
    var SECURITY_KEY_DECODE = ""
        var SECURITY_KEY = "MDI4ZTE4YTViOWUxMTFlYTlkYjZmYTE2M2U1MGYzMjU="

        //    public static void main(String[] args) throws Exception {
        //        String nonce = String.format("%d", Math.abs(new Random().nextInt()));
        //        String timestamp = Long.toString(System.currentTimeMillis() / 1000);
        //        String securityKey = "abc";
        //        System.out.println("sign:" + genCertSign(nonce, timestamp, securityKey));
        //        String SECURITY_KEY_DECODE = new String(EncryptUtils.base64Decode(SECURITY_KEY.getBytes()));
        //    }
        fun genCertSign(): String? {
            nonce = String.format("%d", Math.abs(Random().nextInt()))
            timestamp  = java.lang.Long.toString(System.currentTimeMillis()/1000)
            SECURITY_KEY_DECODE = "028e18a5b9e111ea9db6fa163e50f325"
            println("SECURITY_KEY_DECODE:$SECURITY_KEY_DECODE")
            sign = genCertSign(nonce, timestamp, SECURITY_KEY_DECODE)
            println("sign:$sign timestamp:$timestamp nonce:$nonce SECURITY_KEY_DECODE:$SECURITY_KEY_DECODE")
            return sign
        }

        fun genCertSign(nonce: String, timeStamp: String, securityKey: String): String {
            val sb = StringBuilder()
            try {
                val signElement = arrayOf(nonce, timeStamp, securityKey)
                Arrays.sort(signElement)
                val _rawSign = StringBuffer()
                for(i in signElement.indices){
                    if (i==0) {
                        _rawSign.append(signElement[i])
                    }else{
                        _rawSign.append(" "+signElement[i])
                    }
                }
                val rawSign = _rawSign.toString()
                println("rawSign:$rawSign")
                var md: MessageDigest? = null
                md = MessageDigest.getInstance("SHA-1")
                md.update(rawSign.toByteArray(charset("UTF-8")), 0, rawSign.length)
                val sign = md.digest()
                for (b in sign) {
                    sb.append(String.format("%02x", b))
                }
            } catch (e: Exception) {
                e.printStackTrace()
                return ""
            }
            return sb.toString()
    }
    fun upload(filePath:String):String?{
        genCertSign()
        val url = "https://cv-api.bytedance.com/api/image-process/v1/cartoons"

        val log_id = ""

        val httpPost = HttpPost(url)
        val contentType: ContentType =
                ContentType.create(
                        "application/x-www-form-urlencoded",
                        UTF_8
                ) //解决中文乱码
        val multipartEntityBuilder = MultipartEntityBuilder.create()
        multipartEntityBuilder.setCharset(Consts.UTF_8)
        multipartEntityBuilder.let {
            it.addBinaryBody("image", File(filePath))
            it.addTextBody("log_id", log_id,contentType)
            it.addTextBody("api_key", API_KEY,contentType)
            it.addTextBody("timestamp", timestamp,contentType)
            it.addTextBody("nonce", nonce,contentType)
            it.addTextBody("sign", sign)
        }
        val httpEntity = multipartEntityBuilder.build()
        httpPost.entity = httpEntity
        var response: HttpResponse? = null //发送Post,并返回一个HttpResponse对象
//        val logInterceptor = HttpLoggingInterceptor(HttpLogger()) //创建拦截对象
//        logInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);//这一句一定要记得写，否则没有数据输出
        val httpClient = HttpClients.createDefault()
        response = httpClient.execute(httpPost)
        val result = EntityUtils.toString(response?.getEntity())
        val statusCode = response.getStatusLine().statusCode
        if (statusCode==200) {
            println("response:${result}")
            val imageResult = Gson().fromJson<ImageResult>(result.split("response:")[0],ImageResult::class.java)

            imageResult.data?.image?.let {
                val result = Base64Utils.Base64ToImage(it,"image.jpg")
                if (result) {
                    return "image.jpg"
                }
            }
//            imageResult.data?.clip?.let {
//                Base64Utils.Base64ToImage(it,"clip.jpg")
//            }
        }
        return null

//        if (statusCode == 200) { //如果状态码为200,就是正常返回
//            val result = EntityUtils.toString(response.getEntity())
//            println(result)
//            println(url)
//            val pic = response.getHeaders("Location").first().value
//            println("pic:$pic")
//        }
    }
//    class HttpLogger: HttpLoggingInterceptor.Logger {
//
//        override fun log(message: String) {
//            Log.d(myTag, message);//okHttp的详细日志会打印出来
//        }
//    }
}