package com.cang.controller;


import com.cang.ResponseMessage;
import com.cang.ResponseWrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

@RestController
@Api("上传")
public class UploadController {

    @ApiOperation("上传文件")
    @RequestMapping("/upload")
    public ResponseMessage<Boolean> upload(@RequestParam("test") MultipartFile multipartFile) throws IOException {
        String name = multipartFile.getName();
        String s = multipartFile.getOriginalFilename().split("\\.")[1];
        InputStream inputStream = multipartFile.getInputStream();
        FileOutputStream fileOutputStream = new FileOutputStream(new File("D:/test." + s));
        byte[] bytes = new byte[1024];
        int read = inputStream.read(bytes);
        while (-1 != read){
            fileOutputStream.write(bytes);
            read = inputStream.read(bytes);
        }
        return ResponseWrapper.ok(true);
    }
}
