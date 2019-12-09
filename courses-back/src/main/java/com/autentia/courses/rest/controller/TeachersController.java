package com.autentia.courses.rest.controller;

import com.autentia.courses.persistence.model.Teacher;
import com.autentia.courses.persistence.service.TeacherService;
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
@Path("/teachers")
public class TeachersController {

    TeacherService teacherService;

    @Autowired
    public TeachersController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Teacher> getAllTeachers() {
        log.info("Get the teachers");
        return teacherService.getAllTeachers();
    }
}
