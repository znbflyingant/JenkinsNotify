package com.znb.javalib

/**
 * 描述:
 * 作者：znb
 * 时间：2020/4/11 11:40
 */
object Test {
    @JvmStatic
    fun main(args: Array<String>) {
        val buildnumber = args[1]
        val notifyTester = args[0]
        val jenkinsHost = args[2]
        Const.jenkinsHost = jenkinsHost
        if ("true"!=notifyTester) {
            return
        }
        val username = ""
        val password = ""
        val data = jenkinsutil(Const.jenkinsHost,buildnumber,username,password).jenkinsData
        data?.let {
            SendDingDingUtils().send(it)
        }
    }
}