package com.znb.javalib

/**
 * 描述:
 * 作者：znb
 * 时间：2020/4/11 11:40
 */
object TestCartoonAvatar {
    @JvmStatic
    fun main(args: Array<String>) {
        val url = "cartoontest.jpeg"
        CertSign.upload(url)
    }

}