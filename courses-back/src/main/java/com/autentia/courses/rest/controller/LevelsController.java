package com.autentia.courses.rest.controller;

import com.autentia.courses.persistence.service.CourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Slf4j
@Controller
@Path("/levels")
public class LevelsController {

    CourseService courseService;

    @Autowired
    public LevelsController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<String> getAllTeachers() {
        log.info("Get the course levels");
        return courseService.getCourseLevels();
    }
}
