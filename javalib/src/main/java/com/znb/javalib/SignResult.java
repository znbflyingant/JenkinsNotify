package com.znb.javalib;

/**
 * 描述:
 * 作者：znb
 * 时间：2020/4/13 11:59
 */
public class SignResult {

    /**
     * base_rsp : {"code":0,"msg":"操作成功"}
     * sign : q-sign-algorithm=sha1&q-ak=AKIDuc0C8ocRN3TmqfBZfaGg17xYtzpPt02p&q-sign-time=1586750296;1586753896&q-key-time=1586750296;1586753896&q-header-list=host&q-url-param-list=&q-signature=18d78058311ca32b37b4a6eb2bb83351a0d5ecd3
     * sign_over_time : 1586753896
     * appid : 1258224715
     * region : ap-guangzhou
     * bucket_name : ttc-log-1258224715
     * host : ttc-log-1258224715.cos.ap-guangzhou.myqcloud.com
     * cdn_str : https://uudev-1258224715.cos.ap-guangzhou.myqcloud.com/
     */

    public BaseRspBean base_rsp;
    public String sign;
    public int sign_over_time;
    public String appid;
    public String region;
    public String bucket_name;
    public String host;
    public String cdn_str;

    public static class BaseRspBean {
        /**
         * code : 0
         * msg : 操作成功
         */

        public int code;
        public String msg;
    }
}
