package com.autentia.courses.rest.controller;

import com.autentia.courses.persistence.model.SubjectFile;
import com.autentia.courses.persistence.service.SubjectFileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Slf4j
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/files")
public class FileController {

    private SubjectFileService fileService;

    @Autowired
    public FileController(SubjectFileService fileService) {
        this.fileService = fileService;
    }

    @GetMapping("/{id:[\\d]+}")
    public SubjectFile getSubjectFile(@PathVariable Integer id) {
        SubjectFile file = null;

        log.info("Get subject file " + id);
        file = fileService.getFile(id);
        log.info("Subject file data: " + file);

        return file;
    }

    @PostMapping
    public ResponseEntity<String> uploadData(MultipartFile file) throws IOException {
        SubjectFile subjectFile = new SubjectFile();
        if (file != null) {
            subjectFile.setFileName(file.getOriginalFilename().replace(' ', '_'));
            subjectFile.setType(file.getContentType());
            subjectFile.setData(file.getBytes());

            if (fileService.addFile(subjectFile) == 0) {
                log.error("File not saved");
                return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED)
                        .body("Failed to save file " + file.getOriginalFilename());
            }
        } else {
            log.error("File not found");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("File not added to request");
        }
        log.info("File successfully saved: " + subjectFile);
        return ResponseEntity.status(HttpStatus.OK)
                .body(String.format("id_file: %d", subjectFile.getId()));
    }
}
