package com.autentia.courses.rest.controller;

import com.autentia.courses.persistence.model.CourseData;
import com.autentia.courses.persistence.service.CourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;

@Slf4j
@Controller
@Path("/courses")
public class CoursesController {

    CourseService courseService;

    @Autowired
    public CoursesController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<CourseData> getActiveCourses() {
        log.info("Get active courses");
        return courseService.getActiveCourseData();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addCourse(CourseData courseData) {
        log.info("Add course: " + courseData);
        courseService.addCourse(courseData);
        return Response.created(URI.create("/courses-catalogue/api/v2/courses/" + courseData.getId()))
                .build();
    }
}
