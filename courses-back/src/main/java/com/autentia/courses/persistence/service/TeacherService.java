package com.autentia.courses.persistence.service;

import com.autentia.courses.persistence.model.Teacher;

import java.util.List;

public interface TeacherService {

    List<Teacher> getAllTeachers();

    List<String> getTeacherNames();
}
