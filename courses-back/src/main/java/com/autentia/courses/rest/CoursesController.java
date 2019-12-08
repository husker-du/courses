package com.autentia.courses.rest;

import com.autentia.courses.persistence.model.CourseData;
import com.autentia.courses.persistence.service.CourseService;
import com.autentia.courses.persistence.service.TeacherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class CoursesController {

    CourseService courseService;

    TeacherService teacherService;

    @Autowired
    public CoursesController(CourseService courseService,
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
    public CourseData createCourse(@Valid @RequestBody CourseData courseData) {
        log.info("Register course: " + courseData);
        return courseService.insertCourse(courseData);
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
}
