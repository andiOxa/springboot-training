package com.ucx.training.shop.controller;

import com.ucx.training.shop.service.FileUploadService;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.util.Arrays;


@RestController
@RequestMapping("upload")
@Log4j2
public class FileUploadController {

    @Autowired
    private FileUploadService fileUploadService;

    @PostMapping
    public void uploadFile(@RequestParam("file") MultipartFile file){
        try {
            fileUploadService.saveUploadedFile(file);
        }catch (IOException ex){
            log.error(ex.getMessage());
        }
    }

    @PostMapping("/upload-multiple-files")
    @ResponseBody
        public void uploadMultipleFiles(@RequestParam("files") MultipartFile[] files)  {

                Arrays.asList(files).forEach(file -> {
                    try{
                        fileUploadService.saveUploadedFile(file);
                    }catch (IOException ex){
                        log.error(ex.getMessage());
                    }
                });

    }
}


