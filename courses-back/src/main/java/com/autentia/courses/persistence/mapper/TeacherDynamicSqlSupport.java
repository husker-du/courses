package com.autentia.courses.persistence.mapper;

import java.sql.JDBCType;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class TeacherDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-10T05:48:37.813988+01:00", comments="Source Table: teacher")
    public static final Teacher teacher = new Teacher();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-10T05:48:37.814521+01:00", comments="Source field: teacher.id")
    public static final SqlColumn<Integer> id = teacher.id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-10T05:48:37.815097+01:00", comments="Source field: teacher.first_name")
    public static final SqlColumn<String> firstName = teacher.firstName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-10T05:48:37.815224+01:00", comments="Source field: teacher.last_name")
    public static final SqlColumn<String> lastName = teacher.lastName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-10T05:48:37.815333+01:00", comments="Source field: teacher.age")
    public static final SqlColumn<Integer> age = teacher.age;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-10T05:48:37.814281+01:00", comments="Source Table: teacher")
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