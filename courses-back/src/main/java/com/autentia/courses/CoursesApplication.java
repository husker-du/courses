package com.autentia.courses;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;


@Slf4j
@SpringBootApplication
public class CoursesApplication implements ApplicationRunner {

	public static void main(String[] args) {
		SpringApplication.run(CoursesApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		// Intentionally left empty
	}

	@Bean
	public MultipartResolver multipartResolver() {
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
		multipartResolver.setMaxUploadSize(41943040);
		return multipartResolver;
	}
}
