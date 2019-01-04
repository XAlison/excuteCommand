package com.controller;

import java.io.File;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/upload")
public class UploadController {

    @PostMapping("/index")
    public @ResponseBody
    String Index (HttpServletRequest request, MultipartFile file) {
        try{
            String uploadDir = request.getServletContext().getRealPath("/static/upload/");
            File dir = new File(uploadDir);
            if (!dir.exists()) {
                dir.mkdir();
            }
            String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
            String filename = UUID.randomUUID() + suffix;
            File saveFile = new File(uploadDir + filename);
            file.transferTo(saveFile);
        } catch (Exception e) {
            e.printStackTrace();
            return "upload fail";
        }
        return "upload success";
    }

}
