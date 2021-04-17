package com.yongyongwang.file.manager.response;

import com.yongyongwang.file.manager.SmileContents;
import com.yongyongwang.file.manager.utils.TextUtils;

/**
 * @apiNote yongyongwang
 *
 * @email 1947920597@qq.com
 *
 * @desc:响应封装
 *
 * @// TODO: 2021/4/16
 */
public class SmileResponse {

    /** 响应码 */
    private int code;

    /** 错误提示（只有在发生错误时才会设置） */
    private String msg;

    /** 元数据 */
    private Object data;

    public SmileResponse(int code) {
        this.code = code;
    }

    public SmileResponse(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public SmileResponse(int code, Object data) {
        this.code = code;
        this.data = data;
    }

    /**
     *
     * @return
     */
    public static  String success() {
        return TextUtils.toJSONString(new SmileResponse(SmileContents.RESPONSE_SUCCESS));
    }

    /**
     *
     * @param msg
     * @return
     */
    public static  String success(String msg) {
        return TextUtils.toJSONString(new SmileResponse(SmileContents.RESPONSE_SUCCESS,msg));
    }

    /**
     *
     * @param data
     * @return
     */
    public static  String success(Object data) {
        return TextUtils.toJSONString(new SmileResponse(SmileContents.RESPONSE_SUCCESS, data));
    }

    /**
     *
     * @return
     */
    public static String fail(){
        return TextUtils.toJSONString(new SmileResponse(SmileContents.RESPONSE_FAIL));
    }

    /**
     *
     * @param code
     * @return
     */
    public static String fail(int code){
        return TextUtils.toJSONString(new SmileResponse(code));
    }

    /**
     *
     * @param msg
     * @return
     */
    public static String fail(String msg){
        return TextUtils.toJSONString(new SmileResponse(SmileContents.RESPONSE_FAIL,msg));
    }

    /**
     *
     * @param code
     * @param msg
     * @return
     */
    public static String fail(int code,String msg){
        return TextUtils.toJSONString(new SmileResponse(code, msg));
    }
}
