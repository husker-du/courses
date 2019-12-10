package com.autentia.courses.rest.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

@Slf4j
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/file")
public class FileController {

    @PostMapping("/upload")
    public ResponseEntity<String> uploadData(MultipartFile file) throws IOException {
        log.info("Upload file...");
        if (file != null) {
            InputStream inputStream = file.getInputStream();
            String originalName = file.getOriginalFilename();
            String name = file.getName();
            String contentType = file.getContentType();
            long size = file.getSize();
            log.info("inputStream: " + inputStream);
            log.info("originalName: " + originalName);
            log.info("name: " + name);
            log.info("contentType: " + contentType);
            log.info("size: " + size);
            log.info("size: " + size);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("A file must be added");
        }

        return ResponseEntity.status(HttpStatus.OK)
                .body("File was successfully uploaded");
    }
}
