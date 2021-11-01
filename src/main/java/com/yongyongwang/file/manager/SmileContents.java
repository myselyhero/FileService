package com.yongyongwang.file.manager;

/**
 * @apiNote yongyongwang
 *
 * @email 1947920597@qq.com
 *
 * @desc:静态引用
 *
 * @// TODO: 2021/4/16
 */
public class SmileContents {

    public static final String BASE_PATH = "C:\\smile\\";

    /** 视频保存地址 */
    public static final String VIDEO = "video";
    /** 图片保存路径 */
    public static final String IMAGE = "image";
    /** 图片保存路径 */
    public static final String MUSIC = "music";
    /** 语音保存路径 */
    public static final String VOICE = "voice";
    /**  */
    public static final String FILE = "file";

    /* 返回码 */
    /** 成功 */
    public static final int RESPONSE_SUCCESS = 200;
    /** 失败 */
    public static final int RESPONSE_FAIL = 201;
    /** 参数错误 */
    public static final int RESPONSE_PARAMETER_ERROR = 202;
    /** 文件不存在 */
    public static final int RESPONSE_NO_EXISTENT = 203;
}
