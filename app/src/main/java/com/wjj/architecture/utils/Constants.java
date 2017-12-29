package com.wjj.architecture.utils;

/**
 * 常量集合
 * Created by wjj on 2017/07/03 16:05:08.
 */

public final class Constants {
    public static final class URL {
        public static final String BASE_URL = "http://next.wisedu.com:8013";
    }

    public static final class RESPONSE {
        public static final String UNAUTHORIZED = "login_state_unauthorized";
        public static final String RE_LOGIN = "re_login";
        public static final String API_ERROR = "api_error";
        public static final String FRESH_NOT_EXIST = "fresh_not_exist";
        public static final String PERMISSION_DENIED = "permission_denied";
        public static final String PUBLISH_FRESH_REFUSED = "publish_fresh_refused";

        public static final String PLEASE_WRITE_RESUME = "write_resume";
        public static final String PLEASE_WRITE_RESUME_INFO = "write_resume_info";
        public static final String PLEASE_WRITE_RESUME_COMPLETE = "write_resume_complete";
        public static final String ALREADY_DELIVER = "already_deliver";
        public static final String JOB_IS_NOT_EXIST = "job_not_exist";
        public static final String JOB_DELIVER_FAILURE = "同步简历失败，请稍后重试";
    }
}
