package com.znb.javalib

import java.text.DecimalFormat


object Main {
    @JvmStatic
    fun main(args: Array<String>) {

//        val file =
//            File(QRCodeGenerator.QR_CODE_IMAGE_PATH) //相对路径使用不了的话,使用图片绝对路径
//        if (!file.exists()) { //判断文件是否存在
//            print("文件不存在")
//            return
//        }
//        val url = "https://uudev-1258224715.cos.ap-guangzhou.myqcloud.com/yinpai_android/build_qrcode"
//        val httpClient = HttpClients.createDefault()
//        val httpPost = HttpPost(url) //建立HttpPost对象,改成自己的地址
//        val multipartEntityBuilder = MultipartEntityBuilder.create()
//        multipartEntityBuilder.addBinaryBody("file",File(QRCodeGenerator.QR_CODE_IMAGE_PATH))
//        val httpEntity = multipartEntityBuilder.build()
//        httpPost.entity = httpEntity
//        var response: HttpResponse? = null //发送Post,并返回一个HttpResponse对象
//        try {
//            response = httpClient.execute(httpPost)
//            if (response.getStatusLine().statusCode == 200) { //如果状态码为200,就是正常返回
//                val result = EntityUtils.toString(response.getEntity())
//                print(result)
//            }
//        } catch (e: IOException) {
//            e.printStackTrace()
//        }
//        print(response)
//        print("结束")
        val v = 5200
        val d = DecimalFormat("#.0")
        d.roundingMode = java.math.RoundingMode.DOWN
        var resultFormat = ""
        if (v <= 999) {
            resultFormat = v.toString()
        } else if (v <= 9999) {
            resultFormat = "${d.format(v.toFloat() / 1000)}K"
            println("getMicSeatCountFormat end $resultFormat")
        } else if (v < 9999990) {
            resultFormat = "${d.format(v.toDouble() / 10000)}W"

        } else {
            resultFormat = "999.9W"
        }
        resultFormat = "${d.format(5.2)}K"
        println("getMicSeatCountFormat end $resultFormat")
    }
}