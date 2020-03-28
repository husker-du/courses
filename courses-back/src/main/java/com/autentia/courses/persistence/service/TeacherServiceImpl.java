package com.autentia.courses.persistence.service;

import com.autentia.courses.persistence.dao.TeacherMapper;
import com.autentia.courses.persistence.model.Teacher;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.SelectDSLCompleter;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.autentia.courses.persistence.dao.TeacherDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;
import static org.mybatis.dynamic.sql.select.SelectDSL.select;

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

    @Override
    public List<String> getTeacherNames() {
        return getAllTeachers().stream()
                .map(teacher -> String.format("%s %s", teacher.getFirstName(), teacher.getLastName()))
                .collect(Collectors.toList());
    }

    @Override
    public Teacher getTeacherByName(String firstname, String lastname) {
        Teacher teacherFromDb = null;
        SelectStatementProvider selectStatement = select(id, firstName, lastName, age)
                .from(teacher)
                .where(firstName, isEqualTo(firstname))
                .and(lastName, isEqualTo(lastname))
                .build()
                .render(RenderingStrategies.MYBATIS3);
        Optional<Teacher> optTeacher = teacherMapper.selectOne(selectStatement);
        if (optTeacher.isPresent()) {
            teacherFromDb = optTeacher.get();
        }
        return teacherFromDb;
    }
}
