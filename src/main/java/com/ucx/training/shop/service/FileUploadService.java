package com.ucx.training.shop.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Collectors;


@Service
public class FileUploadService {

    private String Uploaded_Dir = "/Users/Andi/Desktop/SpringBoot/src/main/resources/uploadDir/";

    public void saveUploadedFile(MultipartFile file) throws IOException{

            byte[] bytes = file.getBytes();
            Path path = Paths.get(Uploaded_Dir + file.getOriginalFilename());
            Files.write(path, bytes);

    }



}
