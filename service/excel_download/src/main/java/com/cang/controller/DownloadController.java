package com.cang.controller;

import io.swagger.annotations.Api;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

@RestController
@RequestMapping
@Api(value = "下载")
public class DownloadController {

    @RequestMapping("/download")
    public void downloadTest(HttpServletResponse response) throws IOException {
        ClassPathResource resource = new ClassPathResource("templates/test.xlsx");
        if (!resource.isFile()){
            return;
        }
        File file = resource.getFile();
        response.setContentType("application/octet-stream");
        response.setHeader("content-type", "application/octet-stream");
        response.setHeader("Content-Disposition", "attachment;fileName=" + URLEncoder.encode("index.xlsx","utf8"));
        BufferedInputStream in = new BufferedInputStream(new FileInputStream(file));
        byte[] buffer = new byte[1024];
        ServletOutputStream outputStream = response.getOutputStream();
        int read = in.read(buffer);
        while (read != -1){
            outputStream.write(buffer);
            read = in.read(buffer);
        }
        in.close();
    }
}
