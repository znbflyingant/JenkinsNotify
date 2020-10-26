package com.znb.javalib

import com.dingtalk.api.DefaultDingTalkClient
import com.dingtalk.api.DingTalkClient
import com.dingtalk.api.request.OapiRobotSendRequest
import com.dingtalk.api.response.OapiRobotSendResponse
import com.google.gson.Gson
import org.apache.http.Consts
import org.apache.http.HttpResponse
import org.apache.http.client.methods.HttpPost
import org.apache.http.entity.ContentType
import org.apache.http.entity.StringEntity
import org.apache.http.entity.mime.MultipartEntityBuilder
import org.apache.http.impl.client.HttpClients
import org.apache.http.util.EntityUtils
import java.io.File
import java.io.IOException


/**
 * 描述:
 * 作者：znb
 * 时间：2020/4/11 14:09
 */
class SendDingDingUtils {
    val test = false
    //https://ding-doc.dingtalk.com/doc#/serverapi2/qf2nxq 钉钉文档
    //测试群
    val dingtalkURLDebug = "https://oapi.dingtalk.com/robot/send?access_token=cce053072f11e0bceb46ef9eb57dabe9d46a65a45062c87575018ef569d360bf"
    //#正式群
    val dingtalkURL = "https://oapi.dingtalk.com/robot/send?access_token=382236b1d00aa5c380370024da781f3e0831499dd24096d148931d69e0377c3e"
    fun send(jenkinsData: JenkinsData){
        val client: DingTalkClient = DefaultDingTalkClient(
            if (test) {
                dingtalkURLDebug
            }else{
                dingtalkURL
            }
        )
        val request = OapiRobotSendRequest()
//        request.msgtype = "text"
//        val text = OapiRobotSendRequest.Text()
//        text.content = "小健测试文本消息"
//        request.setText(text)
//        val at = At()
//        at.isAtAll = "True"
//        request.setAt(at)

//        request.msgtype = "link"
//        val link = OapiRobotSendRequest.Link()
//        link.messageUrl = "https://www.dingtalk.com/"
//        link.picUrl = ""
//        link.title = "时代的火车向前开"
//        link.text = "这个即将发布的新版本，创始人xx称它为“红树林”。\n" +
//                "而在此之前，每当面临重大升级，产品经理们都会取一个应景的代号，这一次，为什么是“红树林"
//        request.setLink(link)
//
//

        val apkUrl = "${Const.jenkinsHost}/job/YinpaiAndroid/${jenkinsData.number}/artifact/${jenkinsData.artifacts.first().relativePath}"
        println("apkUrl:$apkUrl")
        val params = mutableMapOf<String,JenkinsData.ActionsBean.ParametersBean>()
        jenkinsData.actions.first().parameters.forEach {
            params.put(it.name,it)
        }
        var CausesBean: JenkinsData.ActionsBean.CausesBean?=null
        try {
            CausesBean = jenkinsData.actions[1].causes.first()
        }catch (e:Exception){
            e.printStackTrace()
        }
        val JENKINS_BUILD_TYPE = "JENKINS_BUILD_TYPE"
        val jenkins_version_des = "jenkins_version_des"
        val jenkins_fix_des = "jenkins_fix_des"
        val JENKINS_INNER_HOST = "JENKINS_INNER_HOST"

        val buildType = params[JENKINS_BUILD_TYPE]?.value?:"buildType"
        val version_dec = params[jenkins_version_des]?.value?:"version_dec"
        val fix_dec = params[jenkins_fix_des]?.value?:"fix_dec"
        val innerHost =  if ("Inner".equals(buildType)) {
            ",Host(${params[JENKINS_INNER_HOST]?.value?:"ws://192.168.8.6:1449"})"
        }else{
            ""
        }
        var _fix_dec = ""
        println("fix_dec:$fix_dec")
        fix_dec.split('\n').forEach {
            _fix_dec += "$it  \n\n"
        }
        val qrcodename = "yinpai_android/build_qrcode/${buildType}/${buildType}_${jenkinsData.number}.png"
        val message = "音派Android $buildType(${jenkinsData.number}) 打包成功"
        if(QRCodeGenerator.generate(buildType,apkUrl,innerHost,jenkinsData)) {
            getSign(qrcodename)?.let {
                println("qrcodename:\n $qrcodename")
                uploadPic(it,qrcodename)?.let {picurl->

                    request.msgtype = "markdown"
                    val markdown = OapiRobotSendRequest.Markdown()
                    markdown.title = message
                    markdown.text = "#### $message  \n\n" +
                            " 备注：$version_dec  \n\n" +
                            " 构建者：${CausesBean?.userName.orEmpty()}  \n\n" +
                            " ![screenshot]($picurl)  \n\n" +
                            " 提测内容  \n\n"+
                            " $_fix_dec"
                    request.setMarkdown(markdown)

                    val rsp: OapiRobotSendResponse = client.execute(request)
                }
            }
        }



    }
    fun getSign(qrcodename:String):SignResult?{
        val url = "http://192.168.8.6:6370/AnonymousReportService/GetUploadLogSign"
        val params = "{\"base_req\":{\"app_id\":10001,\"app_type\":1,\"platform\":2,\"udid\":\"eef81f4b-0f0a-4836-8b52-1c40ba1745e8\"},\"data\":\"{\\\"file_name\\\":\\\"${qrcodename}\\\"}\"}"
        println(params)
        val httpClient = HttpClients.createDefault()
        val httpPost = HttpPost(url) //建立HttpPost对象,改成自己的地址
        httpPost.addHeader("Content-Type","application/json")
        val body = StringEntity(params)
        val multipartEntityBuilder = MultipartEntityBuilder.create()
        multipartEntityBuilder.addTextBody("data-raw",params, ContentType.create("text/json",
            Consts.UTF_8
        ))
        httpPost.entity = body
        var response: HttpResponse? = null //发送Post,并返回一个HttpResponse对象
        try {
            response = httpClient.execute(httpPost)
            if (response.getStatusLine().statusCode == 200) { //如果状态码为200,就是正常返回
                val result = EntityUtils.toString(response.getEntity())
                println(result)
                val signResult = Gson().fromJson<SignResult>(result,SignResult::class.java)
                return signResult
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
            return null
    }
    fun uploadPic(signResult: SignResult,filename:String):String?{
        val url = "${signResult.cdn_str}$filename"
        println("uploadPic url : $url")
        val httpClient = HttpClients.createDefault()
        val httpPost = HttpPost(url) //建立HttpPost对象,改成自己的地址
        httpPost.addHeader("Host",signResult.host)
        httpPost.addHeader("Authorization",signResult.sign)
        val contentType: ContentType =
            ContentType.create(
                "text/plain",
                Consts.UTF_8
            ) //解决中文乱码
        val multipartEntityBuilder = MultipartEntityBuilder.create()
        multipartEntityBuilder.setCharset(Consts.UTF_8)
        multipartEntityBuilder.let {
            it.addBinaryBody("file", File(QRCodeGenerator.QR_CODE_IMAGE_PATH))
            it.addTextBody("Signature",signResult.sign,contentType)
            it.addTextBody("success_action_status","200",contentType)
            it.addTextBody("key",filename,contentType)
            it.addTextBody("op","upload",contentType)
        }
        val httpEntity = multipartEntityBuilder.build()
        httpPost.entity = httpEntity
        var response: HttpResponse? = null //发送Post,并返回一个HttpResponse对象
        try {
            response = httpClient.execute(httpPost)
            val statusCode = response.getStatusLine().statusCode
            println("pic statusCode:$statusCode")
            if (statusCode == 200) { //如果状态码为200,就是正常返回
                val result = EntityUtils.toString(response.getEntity())
                println(result)
                println(url)
                val pic = response.getHeaders("Location").first().value
                println("pic:$pic")
                return pic
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return null
    }
}