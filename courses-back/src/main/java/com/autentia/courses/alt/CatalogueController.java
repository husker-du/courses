package com.autentia.courses.alt;

import com.autentia.courses.persistence.model.CourseData;
import com.autentia.courses.persistence.service.CourseService;
import com.autentia.courses.persistence.service.TeacherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class CatalogueController {

    CourseService courseService;

    TeacherService teacherService;

    @Autowired
    public CatalogueController(CourseService courseService,
                               TeacherService teacherService) {
        this.courseService = courseService;
        this.teacherService = teacherService;
    }

    @GetMapping("/courses")
    public List<CourseData> getActiveCourses() {
        log.info("Get active courses");
        return courseService.getActiveCourseData();
    }

    @PostMapping("/courses")
    public Response createCourse(@Valid @RequestBody CourseData courseData) {
        log.info("Register course: " + courseData);
        courseService.addCourse(courseData);
        return Response.created(URI.create("/courses-catalogue/api/v1/courses/" + courseData.getId()))
                .build();
    }

    @GetMapping("/teachers")
    public List<String> getTeachers() {
        log.info("Get the teachers");
        return teacherService.getAllTeachers().stream()
                .map(teacher -> String.format("%s %s", teacher.getFirstName(), teacher.getLastName()))
                .collect(Collectors.toList());
    }

    @GetMapping("/levels")
    public List<String> getLevels() {
        log.info("Get the course levels");
        return courseService.getCourseLevels();
    }

    @PostMapping("/file/upload")
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
            //throw new RuntimeException("You must select the a file for uploading");
        }

        return ResponseEntity.status(HttpStatus.OK)
                .body("Successfully Uploaded!!!");
    }
}
