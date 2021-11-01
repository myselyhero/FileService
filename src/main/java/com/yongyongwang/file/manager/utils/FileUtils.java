package com.yongyongwang.file.manager.utils;

import com.yongyongwang.file.manager.SmileContents;

import java.io.File;

/**
 * @apiNote yongyongwang
 *
 * @email 1947920597@qq.com
 *
 * @desc:文件工具类
 *
 * @// TODO: 2021/4/16
 */
public class FileUtils {

    /**
     * 是否是视频
     *
     * @param pictureType
     * @return
     */
    public static boolean isVideo(String pictureType) {
        switch (pictureType) {
            case "3gp":
            case "3GP":
            case "3gpp":
            case "3gpp2":
            case "avi":
            case "AVI":
            case "mp4":
            case "MP4":
            case "quicktime":
            case "x-msvideo":
            case "x-matroska":
            case "webm":
            case "mp2ts":
            case "flv":
            case "mov":
                return true;
            default:
                return false;
        }
    }

    /**
     *
     * @param path
     * @return
     */
    public static boolean isVoice(String path){
        switch (path){
            case "m4a":
            case "M4A":
            case "aac":
            case "flac":
                return true;
            default:
                return false;
        }
    }

    /**
     *
     * @param path
     * @return
     */
    public static boolean isMusic(String path){
        switch (path){
            case "mp3":
            case "MP3":
            case "mpeg":
            case "MIDI":
            case "midi":
            case "WMA":
            case "wma":
                return true;
            default:
                return false;
        }
    }

    /**
     *
     * @param path
     * @return
     */
    public static boolean isImage(String path){
        switch (path){
            case "gif":
            case "GIF":
            case "png":
            case "PNG":
            case "jpg":
            case "JPG":
            case "JPEG":
            case "jpeg":
            case "svg":
            case "SVG":
            case "bmp":
            case "jfif":
                return true;
            default:
                return false;
        }
    }

    /**
     * 获取文件类型
     * @param url
     * @return
     */
    public static String fileToType(String url) {
        if (url != null && url.length() > 0) {
            File file = new File(url);
            String name = file.getName();
            if (name.endsWith(".mp4") || name.endsWith(".avi")
                    || name.endsWith(".3gpp") || name.endsWith(".3gp") || name.startsWith(".mov")) {
                return "video/mp4";
            } else if (name.endsWith(".PNG") || name.endsWith(".png") || name.endsWith(".jpeg")
                    || name.endsWith(".gif") || name.endsWith(".GIF") || name.endsWith(".jpg")
                    || name.endsWith(".webp") || name.endsWith(".WEBP") || name.endsWith(".JPEG")
                    || name.endsWith(".bmp")) {
                return "image/jpeg";
            } else if (name.endsWith(".mp3") || name.endsWith(".amr")
                    || name.endsWith(".aac") || name.endsWith(".war")
                    || name.endsWith(".flac") || name.endsWith(".lamr")) {
                return "audio/mpeg";
            }
        }
        return "image/jpeg";
    }

    /**
     *
     * @param url
     * @return
     */
    public static String getBasePath(String url){

        if (url == null || url.length() == 0) {
            return SmileContents.FILE;
        }

        String type = url.substring(url.lastIndexOf(".")+1);

        if (isVideo(type)){
            return SmileContents.VIDEO;
        }else if (isMusic(type)){
            return SmileContents.MUSIC;
        }else if (isVoice(type)){
            return SmileContents.VOICE;
        }else if (isImage(type)){
            return SmileContents.IMAGE;
        }else {
            return SmileContents.FILE;
        }
    }
}
