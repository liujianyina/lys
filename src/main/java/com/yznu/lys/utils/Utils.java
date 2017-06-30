package com.yznu.lys.utils;

import java.security.MessageDigest;
import java.util.Collection;

/**
 * Created by 刘剑银 on 2017/6/26.
 */
public class Utils {

    /**
     * 获取字符串的MD5值
     *
     * @param str
     * @return
     */
    public static String getMD5String(String str) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(str.getBytes("UTF-8"));
            StringBuffer buf = new StringBuffer();
            for (byte b : md.digest()) {
                buf.append(String.format("%02X", b & 0xff));
            }
            return buf.toString();
        } catch (Exception e) {
            e.printStackTrace();

            return "";
        }
    }

    /**
     * 格式化输出
     *
     * @param format
     * @param values
     * @return
     */
    public static String sout(String format, Object... values) {
        return String.format(format, values);
    }

    /**
     * 格式化输出并打印
     *
     * @param format
     * @param values
     */
    public static void soutp(String format, Object... values) {
        System.out.println(sout(format, values));
    }

    /**
     * 判断对象是否为空
     *
     * @param obj
     * @return
     */
    public static boolean isNull(Object obj) {
        return null == obj;
    }

    /**
     * 判断字符串是否为空
     *
     * @param str
     * @return
     */
    public static boolean isEmpty(String str) {
        return isNull(str) || str.trim().length() == 0;
    }

    /**
     * 判断集合是否为空
     *
     * @param collection
     * @return
     */
    public static boolean isEmpty(Collection<?> collection) {
        return isNull(collection) || collection.size() == 0;
    }

    /**
     * 判断数组是否为空
     *
     * @param array
     * @return
     */
    public static boolean isEmpty(Object[] array) {
        return isNull(array) || array.length == 0;
    }


}
