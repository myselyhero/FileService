package com.yongyongwang.file.manager.utils;

import com.google.gson.Gson;

/**
 * @apiNote yongyongwang
 *
 * @email 1947920597@qq.com
 *
 * @desc:字符串工具类
 *
 * @// TODO: 2021/4/16
 */
public class TextUtils {

    /**
     *
     * @param str
     * @return
     */
    public static boolean isEmpty(String str){
        return str == null || str.length() == 0 || "".equals(str.trim());
    }

    /**
     *
     * @param arg
     * @param arg1
     * @return
     */
    public static boolean equals(String arg,String arg1){
        return arg.equals(arg1);
    }

    /**
     * 将Object转字符串
     *
     * @param o
     * @return
     */
    public static String toJSONString(Object o) {
        return new Gson().toJson(o);
    }

    /**
     *
     * @param json
     * @param c
     * @return
     */
    public static Object fromJson(String json,Class c) {
        if (isEmpty(json)){
            return null;
        }
        return new Gson().fromJson(json,c);
    }
}
