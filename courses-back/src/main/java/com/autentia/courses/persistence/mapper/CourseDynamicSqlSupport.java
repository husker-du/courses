package com.autentia.courses.persistence.mapper;

import java.sql.JDBCType;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class CourseDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-05T04:07:51.888014+01:00", comments="Source Table: course")
    public static final Course course = new Course();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-05T04:07:51.888169+01:00", comments="Source field: course.id")
    public static final SqlColumn<Integer> id = course.id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-05T04:07:51.888229+01:00", comments="Source field: course.title")
    public static final SqlColumn<String> title = course.title;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-05T04:07:51.888291+01:00", comments="Source field: course.level")
    public static final SqlColumn<String> level = course.level;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-05T04:07:51.888358+01:00", comments="Source field: course.hours")
    public static final SqlColumn<Integer> hours = course.hours;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-05T04:07:51.888415+01:00", comments="Source field: course.active")
    public static final SqlColumn<Byte> active = course.active;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-05T04:07:51.888495+01:00", comments="Source field: course.id_teacher")
    public static final SqlColumn<Integer> idTeacher = course.idTeacher;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-05T04:07:51.888093+01:00", comments="Source Table: course")
    public static final class Course extends SqlTable {
        public final SqlColumn<Integer> id = column("id", JDBCType.INTEGER);

        public final SqlColumn<String> title = column("title", JDBCType.VARCHAR);

        public final SqlColumn<String> level = column("level", JDBCType.VARCHAR);

        public final SqlColumn<Integer> hours = column("hours", JDBCType.INTEGER);

        public final SqlColumn<Byte> active = column("active", JDBCType.TINYINT);

        public final SqlColumn<Integer> idTeacher = column("id_teacher", JDBCType.INTEGER);

        public Course() {
            super("course");
        }
    }
}