package com.znb.javalib;

import java.io.Serializable;
import java.util.List;

/**
 * Created by znb on 2020/4/11
 */
public class JenkinsData implements Serializable {

    /**
     * _class : hudson.model.FreeStyleBuild
     * actions : [{"_class":"hudson.model.ParametersAction","parameters":[{"_class":"hudson.model.BooleanParameterValue","name":"RN_IS_NPM_INSTALL","value":false},{"_class":"hudson.model.BooleanParameterValue","name":"RN_IS_NPM_JETIFIER","value":false},{"_class":"hudson.model.BooleanParameterValue","name":"IS_COPY_BUNDLE","value":true},{"_class":"hudson.model.BooleanParameterValue","name":"IS_CLEAN","value":true},{"_class":"hudson.model.StringParameterValue","name":"daemon_config","value":" "},{"_class":"hudson.model.StringParameterValue","name":"JENKINS_BUILD_TYPE","value":"Inner"},{"_class":"hudson.model.StringParameterValue","name":"JENKINS_BUILD_TYPE_NDK","value":"phone"},{"_class":"hudson.model.StringParameterValue","name":"JENKINS_BUILD_VERSION","value":"48"},{"_class":"hudson.model.BooleanParameterValue","name":"JENKINS_IS_JENKINS","value":true},{"_class":"hudson.model.BooleanParameterValue","name":"JENKINS_IS_ROBUST","value":false},{"_class":"hudson.model.BooleanParameterValue","name":"JENKINS_IS_DEVTEST","value":false},{"_class":"me.leejay.jenkins.dateparameter.DateParameterValue","name":"JINKINS_BUILDTIME","value":"2020_04_09_11_31_36"},{"_class":"hudson.model.StringParameterValue","name":"JENKINS_BUILD_BRANCH","value":"cocos"}]},{"_class":"hudson.model.CauseAction","causes":[{"_class":"hudson.model.Cause$UserIdCause","shortDescription":"Started by user wuxibo","userId":"wuxibo","userName":"wuxibo"}]},{"_class":"hudson.plugins.git.util.BuildData","buildsByBranchName":{"refs/remotes/origin/cocos":{"_class":"hudson.plugins.git.util.Build","buildNumber":11,"buildResult":null,"marked":{"SHA1":"aae92e10eb79be777595b5158fb7bf706eb6210d","branch":[{"SHA1":"aae92e10eb79be777595b5158fb7bf706eb6210d","name":"refs/remotes/origin/cocos"}]},"revision":{"SHA1":"aae92e10eb79be777595b5158fb7bf706eb6210d","branch":[{"SHA1":"aae92e10eb79be777595b5158fb7bf706eb6210d","name":"refs/remotes/origin/cocos"}]}}},"lastBuiltRevision":{"SHA1":"aae92e10eb79be777595b5158fb7bf706eb6210d","branch":[{"SHA1":"aae92e10eb79be777595b5158fb7bf706eb6210d","name":"refs/remotes/origin/cocos"}]},"remoteUrls":["ssh://git@gitlab.tt19.com:2222/mp_dev/yinpai_app.git"],"scmName":""},{"_class":"hudson.plugins.git.GitTagAction"},{},{},{},{}]
     * artifacts : [{"displayPath":"yinpai-jenkins-innerRelease-v48-1.15.0-2020_04_09_11_31_36-phone.apk","fileName":"yinpai-jenkins-innerRelease-v48-1.15.0-2020_04_09_11_31_36-phone.apk","relativePath":"android/app/build/outputs/apk/innerRelease/yinpai-jenkins-innerRelease-v48-1.15.0-2020_04_09_11_31_36-phone.apk"},{"displayPath":"mapping.txt","fileName":"mapping.txt","relativePath":"android/app/build/outputs/mapping/innerRelease/mapping.txt"},{"displayPath":"sourcemap.js","fileName":"sourcemap.js","relativePath":"android/app/rn_output/sourcemap.js"}]
     * building : false
     * description : null
     * displayName : #11_Inner_48_phone
     * duration : 611645
     * estimatedDuration : 291397
     * executor : null
     * fullDisplayName : YinpaiAndroid #11_Inner_48_phone
     * id : 11
     * keepLog : false
     * number : 11
     * queueId : 506
     * result : SUCCESS
     * timestamp : 1586403105108
     * url : http://192.168.195.14:8080/job/YinpaiAndroid/11/
     * builtOn :
     * changeSet : {"_class":"hudson.plugins.git.GitChangeSetList","items":[{"_class":"hudson.plugins.git.GitChangeSet","affectedPaths":["android/app/src/main/java/com/yinpai/im/ui/ChatFragment.kt","android/app/src/main/res/layout/im_game_invite_view.xml"],"commitId":"aae92e10eb79be777595b5158fb7bf706eb6210d","timestamp":1586402343000,"author":{"absoluteUrl":"http://192.168.195.14:8080/user/zhangjianfeng","fullName":"zhangjianfeng"},"authorEmail":"zhangjianfeng@52tt.com","comment":"邀请游戏UI调整\n","date":"2020-04-09 11:19:03 +0800","id":"aae92e10eb79be777595b5158fb7bf706eb6210d","msg":"邀请游戏UI调整","paths":[{"editType":"edit","file":"android/app/src/main/java/com/yinpai/im/ui/ChatFragment.kt"},{"editType":"edit","file":"android/app/src/main/res/layout/im_game_invite_view.xml"}]}],"kind":"git"}
     * culprits : [{"absoluteUrl":"http://192.168.195.14:8080/user/chensenhai","fullName":"chensenhai"},{"absoluteUrl":"http://192.168.195.14:8080/user/lijiaming","fullName":"lijiaming"},{"absoluteUrl":"http://192.168.195.14:8080/user/zhangjianfeng","fullName":"zhangjianfeng"}]
     */

    public String _class;
    public boolean building;
    public Object description;
    public String displayName;
    public int duration;
    public int estimatedDuration;
    public Object executor;
    public String fullDisplayName;
    public String id;
    public boolean keepLog;
    public int number;
    public int queueId;
    public String result;
    public long timestamp;
    public String url;
    public String builtOn;
    public ChangeSetBean changeSet;
    public List<ActionsBean> actions;
    public List<ArtifactsBean> artifacts;
    public List<CulpritsBean> culprits;

    public static class ChangeSetBean {
        /**
         * _class : hudson.plugins.git.GitChangeSetList
         * items : [{"_class":"hudson.plugins.git.GitChangeSet","affectedPaths":["android/app/src/main/java/com/yinpai/im/ui/ChatFragment.kt","android/app/src/main/res/layout/im_game_invite_view.xml"],"commitId":"aae92e10eb79be777595b5158fb7bf706eb6210d","timestamp":1586402343000,"author":{"absoluteUrl":"http://192.168.195.14:8080/user/zhangjianfeng","fullName":"zhangjianfeng"},"authorEmail":"zhangjianfeng@52tt.com","comment":"邀请游戏UI调整\n","date":"2020-04-09 11:19:03 +0800","id":"aae92e10eb79be777595b5158fb7bf706eb6210d","msg":"邀请游戏UI调整","paths":[{"editType":"edit","file":"android/app/src/main/java/com/yinpai/im/ui/ChatFragment.kt"},{"editType":"edit","file":"android/app/src/main/res/layout/im_game_invite_view.xml"}]}]
         * kind : git
         */

        public String _class;
        public String kind;
        public List<ItemsBean> items;

        public static class ItemsBean {
            /**
             * _class : hudson.plugins.git.GitChangeSet
             * affectedPaths : ["android/app/src/main/java/com/yinpai/im/ui/ChatFragment.kt","android/app/src/main/res/layout/im_game_invite_view.xml"]
             * commitId : aae92e10eb79be777595b5158fb7bf706eb6210d
             * timestamp : 1586402343000
             * author : {"absoluteUrl":"http://192.168.195.14:8080/user/zhangjianfeng","fullName":"zhangjianfeng"}
             * authorEmail : zhangjianfeng@52tt.com
             * comment : 邀请游戏UI调整
             * date : 2020-04-09 11:19:03 +0800
             * id : aae92e10eb79be777595b5158fb7bf706eb6210d
             * msg : 邀请游戏UI调整
             * paths : [{"editType":"edit","file":"android/app/src/main/java/com/yinpai/im/ui/ChatFragment.kt"},{"editType":"edit","file":"android/app/src/main/res/layout/im_game_invite_view.xml"}]
             */

            public String _class;
            public String commitId;
            public long timestamp;
            public AuthorBean author;
            public String authorEmail;
            public String comment;
            public String date;
            public String id;
            public String msg;
            public List<String> affectedPaths;
            public List<PathsBean> paths;

            public static class AuthorBean {
                /**
                 * absoluteUrl : http://192.168.195.14:8080/user/zhangjianfeng
                 * fullName : zhangjianfeng
                 */

                public String absoluteUrl;
                public String fullName;
            }

            public static class PathsBean {
                /**
                 * editType : edit
                 * file : android/app/src/main/java/com/yinpai/im/ui/ChatFragment.kt
                 */

                public String editType;
                public String file;
            }
        }
    }

    public static class ActionsBean {
        /**
         * _class : hudson.model.ParametersAction
         * parameters : [{"_class":"hudson.model.BooleanParameterValue","name":"RN_IS_NPM_INSTALL","value":false},{"_class":"hudson.model.BooleanParameterValue","name":"RN_IS_NPM_JETIFIER","value":false},{"_class":"hudson.model.BooleanParameterValue","name":"IS_COPY_BUNDLE","value":true},{"_class":"hudson.model.BooleanParameterValue","name":"IS_CLEAN","value":true},{"_class":"hudson.model.StringParameterValue","name":"daemon_config","value":" "},{"_class":"hudson.model.StringParameterValue","name":"JENKINS_BUILD_TYPE","value":"Inner"},{"_class":"hudson.model.StringParameterValue","name":"JENKINS_BUILD_TYPE_NDK","value":"phone"},{"_class":"hudson.model.StringParameterValue","name":"JENKINS_BUILD_VERSION","value":"48"},{"_class":"hudson.model.BooleanParameterValue","name":"JENKINS_IS_JENKINS","value":true},{"_class":"hudson.model.BooleanParameterValue","name":"JENKINS_IS_ROBUST","value":false},{"_class":"hudson.model.BooleanParameterValue","name":"JENKINS_IS_DEVTEST","value":false},{"_class":"me.leejay.jenkins.dateparameter.DateParameterValue","name":"JINKINS_BUILDTIME","value":"2020_04_09_11_31_36"},{"_class":"hudson.model.StringParameterValue","name":"JENKINS_BUILD_BRANCH","value":"cocos"}]
         * causes : [{"_class":"hudson.model.Cause$UserIdCause","shortDescription":"Started by user wuxibo","userId":"wuxibo","userName":"wuxibo"}]
         * buildsByBranchName : {"refs/remotes/origin/cocos":{"_class":"hudson.plugins.git.util.Build","buildNumber":11,"buildResult":null,"marked":{"SHA1":"aae92e10eb79be777595b5158fb7bf706eb6210d","branch":[{"SHA1":"aae92e10eb79be777595b5158fb7bf706eb6210d","name":"refs/remotes/origin/cocos"}]},"revision":{"SHA1":"aae92e10eb79be777595b5158fb7bf706eb6210d","branch":[{"SHA1":"aae92e10eb79be777595b5158fb7bf706eb6210d","name":"refs/remotes/origin/cocos"}]}}}
         * lastBuiltRevision : {"SHA1":"aae92e10eb79be777595b5158fb7bf706eb6210d","branch":[{"SHA1":"aae92e10eb79be777595b5158fb7bf706eb6210d","name":"refs/remotes/origin/cocos"}]}
         * remoteUrls : ["ssh://git@gitlab.tt19.com:2222/mp_dev/yinpai_app.git"]
         * scmName :
         */

        public String _class;
        public BuildsByBranchNameBean buildsByBranchName;
        public LastBuiltRevisionBean lastBuiltRevision;
        public String scmName;
        public List<ParametersBean> parameters;
        public List<CausesBean> causes;
        public List<String> remoteUrls;

        // FIXME generate failure  field _$RefsRemotesOriginCocos125
        public static class BuildsByBranchNameBean {

                    public static class MarkedBean {
                        /**
                         * SHA1 : aae92e10eb79be777595b5158fb7bf706eb6210d
                         * branch : [{"SHA1":"aae92e10eb79be777595b5158fb7bf706eb6210d","name":"refs/remotes/origin/cocos"}]
                         */

                        public String SHA1;
                        public List<BranchBean> branch;

                        public static class BranchBean {
                            /**
                             * SHA1 : aae92e10eb79be777595b5158fb7bf706eb6210d
                             * name : refs/remotes/origin/cocos
                             */

                            public String SHA1;
                            public String name;
                        }
                    }

                    public static class RevisionBean {
                        /**
                         * SHA1 : aae92e10eb79be777595b5158fb7bf706eb6210d
                         * branch : [{"SHA1":"aae92e10eb79be777595b5158fb7bf706eb6210d","name":"refs/remotes/origin/cocos"}]
                         */

                        public String SHA1;
                        public List<BranchBeanX> branch;

                        public static class BranchBeanX {
                            /**
                             * SHA1 : aae92e10eb79be777595b5158fb7bf706eb6210d
                             * name : refs/remotes/origin/cocos
                             */

                            public String SHA1;
                            public String name;
                        }
                    }

                    /**
                     * _class : hudson.plugins.git.util.Build
                     * buildNumber : 11
                     * buildResult : null
                     * marked : {"SHA1":"aae92e10eb79be777595b5158fb7bf706eb6210d","branch":[{"SHA1":"aae92e10eb79be777595b5158fb7bf706eb6210d","name":"refs/remotes/origin/cocos"}]}
                     * revision : {"SHA1":"aae92e10eb79be777595b5158fb7bf706eb6210d","branch":[{"SHA1":"aae92e10eb79be777595b5158fb7bf706eb6210d","name":"refs/remotes/origin/cocos"}]}
                     */

                    public String _class;
                    public int buildNumber;
                    public Object buildResult;
                    public MarkedBean marked;
                    public RevisionBean revision;
        }

        public static class LastBuiltRevisionBean {
            /**
             * SHA1 : aae92e10eb79be777595b5158fb7bf706eb6210d
             * branch : [{"SHA1":"aae92e10eb79be777595b5158fb7bf706eb6210d","name":"refs/remotes/origin/cocos"}]
             */

            public String SHA1;
            public List<BranchBeanXX> branch;

            public static class BranchBeanXX {
                /**
                 * SHA1 : aae92e10eb79be777595b5158fb7bf706eb6210d
                 * name : refs/remotes/origin/cocos
                 */

                public String SHA1;
                public String name;
            }
        }

        public static class ParametersBean {
            /**
             * _class : hudson.model.BooleanParameterValue
             * name : RN_IS_NPM_INSTALL
             * value : false
             */

            public String _class;
            public String name;
            public String value;
        }

        public static class CausesBean {
            /**
             * _class : hudson.model.Cause$UserIdCause
             * shortDescription : Started by user wuxibo
             * userId : wuxibo
             * userName : wuxibo
             */

            public String _class;
            public String shortDescription;
            public String userId;
            public String userName;
        }
    }

    public static class ArtifactsBean {
        /**
         * displayPath : yinpai-jenkins-innerRelease-v48-1.15.0-2020_04_09_11_31_36-phone.apk
         * fileName : yinpai-jenkins-innerRelease-v48-1.15.0-2020_04_09_11_31_36-phone.apk
         * relativePath : android/app/build/outputs/apk/innerRelease/yinpai-jenkins-innerRelease-v48-1.15.0-2020_04_09_11_31_36-phone.apk
         */

        public String displayPath;
        public String fileName;
        public String relativePath;
    }

    public static class CulpritsBean {
        /**
         * absoluteUrl : http://192.168.195.14:8080/user/chensenhai
         * fullName : chensenhai
         */

        public String absoluteUrl;
        public String fullName;
    }
}
