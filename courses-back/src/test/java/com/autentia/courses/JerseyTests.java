package com.autentia.courses;

import com.autentia.courses.rest.controller.CoursesController;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.Application;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static org.springframework.test.util.AssertionErrors.assertEquals;


public class JerseyTests extends JerseyTest {
    @Override
    protected Application configure() {
        return new ResourceConfig()
                .register(CoursesController.class)
                .register(JacksonFeature.class);
    }

    @Test
    public void givenGetHiGreeting_whenCorrectRequest_thenResponseIsOkAndContainsHi() {
        Response response = target("/api/v1/courses").request()
                .header("Access-Control-Request-Method", "GET")
                .header("Origin", "http://localhost:4200")
                .get();
;

        assertEquals("Http Response should be 200: ", Response.Status.OK.getStatusCode(), response.getStatus());
        assertEquals("Http Content-Type should be: ", MediaType.APPLICATION_JSON, response.getHeaderString(HttpHeaders.CONTENT_TYPE));

        String content = response.readEntity(String.class);
        //assertEquals("Content of ressponse is: ", "hi", content);
    }
}
