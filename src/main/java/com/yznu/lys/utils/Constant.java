package com.yznu.lys.utils;

import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.text.SimpleDateFormat;

/**
 * 全局静态值
 * <p>
 * Created by 刘剑银 on 2017/6/26.
 */
public class Constant {

    public final static String TABLE_PREFIX = "lys_";

    public final static SimpleDateFormat SF_FULL_DATE_TIME = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public final static SimpleDateFormat SF_DATE = new SimpleDateFormat("yyyy-MM-dd");
    public final static SimpleDateFormat SF_DATE_DOT = new SimpleDateFormat("yyyy.MM.dd");

    public final static DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");

    public final static String STR_FULL_DATE_TIME = "yyyy-MM-dd HH:mm:ss";

    /**
     * 默认每页显示记录数
     */
    public final static String DEFAULT_PAGE_SIZE = "10";

    public final class SessionKey {
        /**
         * 当前登录用户
         */
        public static final String CURRENT_USER = "com.yznu.lys.session.user";
        public static final String CURRENT_USER_NAME = "com.yznu.lys.session.user_name";

        /**
         * 当前登录用户菜单
         */
        public static final String AVAILABLE_MENU = "com.yznu.lys.session.available_menu";
    }


}
