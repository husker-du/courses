package com.autentia.courses.persistence.service;

import com.autentia.courses.persistence.model.Teacher;

import java.util.List;

public interface TeacherService {

    List<Teacher> getAllTeachers();

    List<String> getTeacherNames();

    Teacher getTeacherByName(final String firstname, final String lastname);

    Teacher getTeacherById(final Integer id);

    Long numTeachersByAge(final Integer age);
}
