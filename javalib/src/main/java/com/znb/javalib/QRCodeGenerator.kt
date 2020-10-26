package com.znb.javalib

import java.io.File

object QRCodeGenerator {
    const val QR_CODE_IMAGE_PATH = "MyQRCode.png"
    fun generate(
        buildType: String,
        apkUrl: String,
        innerHost:String,
        jenkinsData: JenkinsData
    ):Boolean{
        //logo
        val logoFile = File("javalib/archive/$buildType.png")
        //背景图片
        val bgFile = null
        //生成图片
        val qrCodeFile = File(QR_CODE_IMAGE_PATH)
        //二维码内容
        val url = apkUrl
        //二维码下面的文字

        val words = "$buildType (${jenkinsData.number})${innerHost}"
        try {
            BarcodeUtils.drawLogoQRCode(null, bgFile, qrCodeFile, url, words)
            return true
        }catch (e:Exception){
            e.printStackTrace()
        }
        return false
        
    }
}