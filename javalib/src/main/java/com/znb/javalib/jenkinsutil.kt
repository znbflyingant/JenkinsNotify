package com.znb.javalib

import com.google.gson.Gson
import org.apache.http.HttpHost
import org.apache.http.HttpResponse
import org.apache.http.auth.AuthScope
import org.apache.http.auth.UsernamePasswordCredentials
import org.apache.http.client.AuthCache
import org.apache.http.client.CredentialsProvider
import org.apache.http.client.methods.HttpGet
import org.apache.http.client.protocol.HttpClientContext
import org.apache.http.impl.auth.BasicScheme
import org.apache.http.impl.client.BasicAuthCache
import org.apache.http.impl.client.BasicCredentialsProvider
import org.apache.http.impl.client.HttpClients
import org.apache.http.util.EntityUtils
import java.io.IOException
import java.net.URI

/**
 * Created by znb on 2020/4/11
 */
class jenkinsutil(val jenkinsUrl: String,val buildNumber:String, val username: String, val password: String) {
    /**
     * 获取数据
     * @return
     */
    val jenkinsData: JenkinsData?
        get() {
            try {
                val urlString = "$jenkinsUrl/job/YinpaiAndroid/$buildNumber/api/json?pretty=true"
                println("urlString \n $urlString")
                val jobsString = getJobs(urlString, username, password)
                println("jobsString \n $jobsString")
                val jenkinsData = Gson().fromJson<JenkinsData>(jobsString,JenkinsData::class.java)
                return jenkinsData
            } catch (e: IOException) {
                e.printStackTrace()
            }
            return null
        }

    companion object {
        /**
         * 执行语句，上面已经定义了成员变量，String username,String password可以不用传，我是后面有再次调用该方法，所以又传递了一遍，这里可以按照自己所需来处理。
         * @param urlString
         * @return
         * @throws IOException
         */
        @Throws(IOException::class)
        fun getJobs(urlString: String, username: String, password: String): String {
            val uri = URI.create(urlString)
            val host = HttpHost(uri.host, uri.port, uri.scheme)
            val credsProvider: CredentialsProvider = BasicCredentialsProvider()
            credsProvider.setCredentials(AuthScope(uri.host, uri.port), UsernamePasswordCredentials(username, password))
            val authCache: AuthCache = BasicAuthCache()
            val basicAuth = BasicScheme()
            authCache.put(host, basicAuth)
            val httpClient = HttpClients.custom()
                    .setDefaultCredentialsProvider(credsProvider)
                    .build()
            val httpGet = HttpGet(uri)
            val localContext = HttpClientContext.create()
            localContext.authCache = authCache
            val response: HttpResponse = httpClient.execute(host, httpGet)
            return EntityUtils.toString(response.entity)
        }
    }

}