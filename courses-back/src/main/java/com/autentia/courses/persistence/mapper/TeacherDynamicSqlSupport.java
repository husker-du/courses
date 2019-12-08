package com.autentia.courses.persistence.mapper;

import java.sql.JDBCType;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class TeacherDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-05T04:07:51.867307+01:00", comments="Source Table: teacher")
    public static final Teacher teacher = new Teacher();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-05T04:07:51.867664+01:00", comments="Source field: teacher.id")
    public static final SqlColumn<Integer> id = teacher.id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-05T04:07:51.868159+01:00", comments="Source field: teacher.first_name")
    public static final SqlColumn<String> firstName = teacher.firstName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-05T04:07:51.868292+01:00", comments="Source field: teacher.last_name")
    public static final SqlColumn<String> lastName = teacher.lastName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-05T04:07:51.868414+01:00", comments="Source field: teacher.age")
    public static final SqlColumn<Integer> age = teacher.age;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-05T04:07:51.867524+01:00", comments="Source Table: teacher")
    public static final class Teacher extends SqlTable {
        public final SqlColumn<Integer> id = column("id", JDBCType.INTEGER);

        public final SqlColumn<String> firstName = column("first_name", JDBCType.VARCHAR);

        public final SqlColumn<String> lastName = column("last_name", JDBCType.VARCHAR);

        public final SqlColumn<Integer> age = column("age", JDBCType.INTEGER);

        public Teacher() {
            super("teacher");
        }
    }
}