package com.autentia.courses.rest.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartFile;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.io.InputStream;

@Slf4j
@Controller
public class FileController {

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Path("/upload")
    public Response uploadData(MultipartFile file) throws IOException {
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

        return Response.status(Response.Status.OK)
               .build();
    }

}
