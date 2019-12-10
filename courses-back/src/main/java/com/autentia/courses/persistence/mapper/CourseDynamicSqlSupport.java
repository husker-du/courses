package com.autentia.courses.persistence.mapper;

import java.sql.JDBCType;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class CourseDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-10T05:48:37.834768+01:00", comments="Source Table: course")
    public static final Course course = new Course();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-10T05:48:37.835008+01:00", comments="Source field: course.id")
    public static final SqlColumn<Integer> id = course.id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-10T05:48:37.835115+01:00", comments="Source field: course.title")
    public static final SqlColumn<String> title = course.title;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-10T05:48:37.835204+01:00", comments="Source field: course.level")
    public static final SqlColumn<String> level = course.level;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-10T05:48:37.835282+01:00", comments="Source field: course.hours")
    public static final SqlColumn<Integer> hours = course.hours;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-10T05:48:37.835377+01:00", comments="Source field: course.active")
    public static final SqlColumn<Byte> active = course.active;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-10T05:48:37.835456+01:00", comments="Source field: course.id_teacher")
    public static final SqlColumn<Integer> idTeacher = course.idTeacher;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-10T05:48:37.83553+01:00", comments="Source field: course.id_file")
    public static final SqlColumn<Integer> idFile = course.idFile;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-10T05:48:37.834875+01:00", comments="Source Table: course")
    public static final class Course extends SqlTable {
        public final SqlColumn<Integer> id = column("id", JDBCType.INTEGER);

        public final SqlColumn<String> title = column("title", JDBCType.VARCHAR);

        public final SqlColumn<String> level = column("level", JDBCType.CHAR);

        public final SqlColumn<Integer> hours = column("hours", JDBCType.INTEGER);

        public final SqlColumn<Byte> active = column("active", JDBCType.TINYINT);

        public final SqlColumn<Integer> idTeacher = column("id_teacher", JDBCType.INTEGER);

        public final SqlColumn<Integer> idFile = column("id_file", JDBCType.INTEGER);

        public Course() {
            super("course");
        }
    }
}