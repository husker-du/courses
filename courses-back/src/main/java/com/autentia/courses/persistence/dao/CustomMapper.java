package com.autentia.courses.persistence.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface CustomMapper {
    @Select("SELECT COLUMN_TYPE " +
            "FROM INFORMATION_SCHEMA.COLUMNS " +
            "WHERE TABLE_SCHEMA = (SELECT DATABASE()) " +
            "AND TABLE_NAME = \'course\' " +
            "AND COLUMN_NAME = \'level\'")
    String getLevelEnum();

    @Select("SELECT id " +
            "FROM teacher " +
            "WHERE CONCAT(first_name, ' ', last_name) = #{teacherName}")
    Integer findTeacherIdByName(String teacherName);
}