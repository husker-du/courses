package com.autentia.courses.rest.controller;

import com.autentia.courses.persistence.service.CustomService;
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

    private CustomService customService;

    @Autowired
    public LevelsController(final CustomService customService) {
        this.customService = customService;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<String> getAllTeachers() {
        log.info("Get the course levels");
        return customService.getCourseLevels();
    }
}
