package com.yongyongwang.file.manager.controller;

import com.yongyongwang.file.manager.SmileContents;
import com.yongyongwang.file.manager.response.SmileResponse;
import com.yongyongwang.file.manager.utils.FileUtils;
import com.yongyongwang.file.manager.utils.TextUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

/**
 * @apiNote yongyongwang
 *
 * @email 1947920597@qq.com
 *
 * @desc:文件控制器
 *
 * @// TODO: 2021/4/16
 */
@RestController
@RequestMapping("/file")
public class FileController {

    @PostMapping("/uploadFile")
    public String uploadFile(HttpServletRequest request, HttpServletResponse response, @RequestParam(value = "file", required = false) MultipartFile[] files)
            throws IllegalStateException, IOException {
        // TODO 进入方法前
        response.setHeader("Access-Control-Allow-Origin", "*");
        // 响应类型
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, DELETE, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");

        if (files == null) {
            return SmileResponse.fail(SmileContents.RESPONSE_PARAMETER_ERROR);
        }

        //返回的路径
        String file = "";
        //http://localhost:8090\smile\
        String resultUrl = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/smile/";

        for (int i = 0; i < files.length; i++) {
            if (!files[i].isEmpty()) {
                try {
                    //request.getSession().getServletContext().getRealPath("/")

                    File basePath = new File(SmileContents.BASE_PATH);
                    if (!basePath.exists()) {
                        basePath.mkdir();
                    }

                    /** 文件夹不存在则创建 */
                    String folder = FileUtils.getBasePath(files[i].getOriginalFilename());
                    File packFile = new File(SmileContents.BASE_PATH + folder);
                    if (!packFile.exists()) {
                        packFile.mkdir();
                    }

                    /** 输出路径 */
                    String outName = folder + "/" + UUID.randomUUID().toString().replace("-","") + "_" + files[i].getOriginalFilename();
                    String outUrl = SmileContents.BASE_PATH + outName;

                    /** 写入 */
                    FileOutputStream os = new FileOutputStream(outUrl);
                    InputStream in = files[i].getInputStream();
                    int b;
                    while ((b = in.read()) != -1) {
                        os.write(b);
                    }
                    os.flush();
                    os.close();
                    in.close();

                    /** 返回路径 */
                    if (!TextUtils.isEmpty(file)) {
                        file += ",";
                    }
                    file += resultUrl + outName;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        if (TextUtils.isEmpty(file)) {
            return SmileResponse.fail();
        }

        return SmileResponse.success(file);
    }

    @PostMapping("/deleteFile")
    public String deleteFile(HttpServletRequest request,@RequestParam(value = "fileName") String fileName){

        if (TextUtils.isEmpty(fileName)){
            return SmileResponse.fail(SmileContents.RESPONSE_PARAMETER_ERROR);
        }

        /** 将serverPath去掉 */
        String server = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/smile/";
        String name = fileName.replace(server,"");

        //request.getSession().getServletContext().getRealPath("/")
        try {
            File file = new File(SmileContents.BASE_PATH + name);
            if (!file.exists()){
                return SmileResponse.fail(SmileContents.RESPONSE_NO_EXISTENT,"文件不存在");
            }
            if (!file.isFile()){
                return SmileResponse.fail(SmileContents.RESPONSE_PARAMETER_ERROR,"请传入文件");
            }
            file.delete();
            return SmileResponse.success();
        }catch (Exception e){
            return SmileResponse.fail(SmileContents.RESPONSE_NO_EXISTENT,"文件不存在或读取失败");
        }
    }
}
