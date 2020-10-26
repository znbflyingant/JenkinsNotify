package com.znb.javalib;

/**
 * 描述:
 * 作者：znb
 * 时间：2020/7/8 14:46
 */
class ImageResult {

    /**
     * code : 10000
     * data : {"clip":"","image":"","message":"Success","request_id":"68469980785708912641594190970","time_elapsed":"435.739452ms"}
     */

    public int code;
    public DataBean data;

    public static class DataBean {
        /**
         * clip :
         * image :
         * message : Success
         * request_id : 68469980785708912641594190970
         * time_elapsed : 435.739452ms
         */

        public String clip;
        public String image;
        public String message;
        public String request_id;
        public String time_elapsed;
    }
}
