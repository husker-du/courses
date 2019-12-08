package com.autentia.courses.persistence.service;

import com.autentia.courses.persistence.mapper.TeacherMapper;
import com.autentia.courses.persistence.model.Teacher;
import org.mybatis.dynamic.sql.select.SelectDSLCompleter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    private TeacherMapper teacherMapper;

    @Autowired
    public TeacherServiceImpl(TeacherMapper teacherMapper) {
        this.teacherMapper = teacherMapper;
    }

    @Override
    public List<Teacher> getAllTeachers() {
        return teacherMapper.select(SelectDSLCompleter.allRows());
    }
}
