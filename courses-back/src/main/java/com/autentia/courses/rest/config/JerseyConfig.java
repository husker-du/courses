package com.autentia.courses.rest.config;

import com.autentia.courses.rest.controller.CoursesController;
import com.autentia.courses.rest.controller.FileController;
import com.autentia.courses.rest.controller.LevelsController;
import com.autentia.courses.rest.controller.TeachersController;
import com.autentia.courses.rest.exception.GenericExceptionMapper;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.ws.rs.ApplicationPath;

@Configuration
@ApplicationPath("/api/v2")
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        // Intentionally left empty
    }

    @PostConstruct
    public void init() {
        register(CoursesController.class);
        register(TeachersController.class);
        register(LevelsController.class);
        register(GenericExceptionMapper.class);
        register(CORSFilter.class);
    }
}
