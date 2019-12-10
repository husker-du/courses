package com.autentia.courses.persistence.mapper;

import java.sql.JDBCType;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class SubjectFileDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-10T00:20:08.18007+01:00", comments="Source Table: subject_file")
    public static final SubjectFile subjectFile = new SubjectFile();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-10T00:20:08.180294+01:00", comments="Source field: subject_file.id")
    public static final SqlColumn<Integer> id = subjectFile.id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-10T00:20:08.180398+01:00", comments="Source field: subject_file.file_name")
    public static final SqlColumn<String> fileName = subjectFile.fileName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-10T00:20:08.180505+01:00", comments="Source field: subject_file.type")
    public static final SqlColumn<String> type = subjectFile.type;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-10T00:20:08.180557+01:00", comments="Source field: subject_file.data")
    public static final SqlColumn<byte[]> data = subjectFile.data;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-10T00:20:08.180215+01:00", comments="Source Table: subject_file")
    public static final class SubjectFile extends SqlTable {
        public final SqlColumn<Integer> id = column("id", JDBCType.INTEGER);

        public final SqlColumn<String> fileName = column("file_name", JDBCType.VARCHAR);

        public final SqlColumn<String> type = column("type", JDBCType.VARCHAR);

        public final SqlColumn<byte[]> data = column("data", JDBCType.LONGVARBINARY);

        public SubjectFile() {
            super("subject_file");
        }
    }
}