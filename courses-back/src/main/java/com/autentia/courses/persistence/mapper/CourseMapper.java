package com.autentia.courses.persistence.mapper;

import static com.autentia.courses.persistence.mapper.CourseDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.autentia.courses.persistence.model.Course;
import java.util.List;
import java.util.Optional;
import javax.annotation.Generated;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.dynamic.sql.BasicColumn;
import org.mybatis.dynamic.sql.delete.DeleteDSLCompleter;
import org.mybatis.dynamic.sql.delete.render.DeleteStatementProvider;
import org.mybatis.dynamic.sql.insert.render.InsertStatementProvider;
import org.mybatis.dynamic.sql.select.CountDSLCompleter;
import org.mybatis.dynamic.sql.select.SelectDSLCompleter;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.update.UpdateDSL;
import org.mybatis.dynamic.sql.update.UpdateDSLCompleter;
import org.mybatis.dynamic.sql.update.UpdateModel;
import org.mybatis.dynamic.sql.update.render.UpdateStatementProvider;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;
import org.mybatis.dynamic.sql.util.mybatis3.MyBatis3Utils;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface CourseMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-10T05:48:37.836713+01:00", comments="Source Table: course")
    BasicColumn[] selectList = BasicColumn.columnList(id, title, level, hours, active, idTeacher, idFile);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-10T05:48:37.835612+01:00", comments="Source Table: course")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-10T05:48:37.835683+01:00", comments="Source Table: course")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-10T05:48:37.83575+01:00", comments="Source Table: course")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="record.id", before=false, resultType=Integer.class)
    int insert(InsertStatementProvider<Course> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-10T05:48:37.835901+01:00", comments="Source Table: course")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("CourseResult")
    Optional<Course> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-10T05:48:37.835987+01:00", comments="Source Table: course")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="CourseResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="level", property="level", jdbcType=JdbcType.CHAR),
        @Result(column="hours", property="hours", jdbcType=JdbcType.INTEGER),
        @Result(column="active", property="active", jdbcType=JdbcType.TINYINT),
        @Result(column="id_teacher", property="idTeacher", jdbcType=JdbcType.INTEGER),
        @Result(column="id_file", property="idFile", jdbcType=JdbcType.INTEGER)
    })
    List<Course> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-10T05:48:37.836128+01:00", comments="Source Table: course")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-10T05:48:37.836195+01:00", comments="Source Table: course")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, course, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-10T05:48:37.836261+01:00", comments="Source Table: course")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, course, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-10T05:48:37.836326+01:00", comments="Source Table: course")
    default int deleteByPrimaryKey(Integer id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-10T05:48:37.836397+01:00", comments="Source Table: course")
    default int insert(Course record) {
        return MyBatis3Utils.insert(this::insert, record, course, c ->
            c.map(title).toProperty("title")
            .map(level).toProperty("level")
            .map(hours).toProperty("hours")
            .map(active).toProperty("active")
            .map(idTeacher).toProperty("idTeacher")
            .map(idFile).toProperty("idFile")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-10T05:48:37.836514+01:00", comments="Source Table: course")
    default int insertSelective(Course record) {
        return MyBatis3Utils.insert(this::insert, record, course, c ->
            c.map(title).toPropertyWhenPresent("title", record::getTitle)
            .map(level).toPropertyWhenPresent("level", record::getLevel)
            .map(hours).toPropertyWhenPresent("hours", record::getHours)
            .map(active).toPropertyWhenPresent("active", record::getActive)
            .map(idTeacher).toPropertyWhenPresent("idTeacher", record::getIdTeacher)
            .map(idFile).toPropertyWhenPresent("idFile", record::getIdFile)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-10T05:48:37.836796+01:00", comments="Source Table: course")
    default Optional<Course> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, course, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-10T05:48:37.836862+01:00", comments="Source Table: course")
    default List<Course> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, course, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-10T05:48:37.836935+01:00", comments="Source Table: course")
    default List<Course> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, course, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-10T05:48:37.837002+01:00", comments="Source Table: course")
    default Optional<Course> selectByPrimaryKey(Integer id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-10T05:48:37.837074+01:00", comments="Source Table: course")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, course, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-10T05:48:37.83715+01:00", comments="Source Table: course")
    static UpdateDSL<UpdateModel> updateAllColumns(Course record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(title).equalTo(record::getTitle)
                .set(level).equalTo(record::getLevel)
                .set(hours).equalTo(record::getHours)
                .set(active).equalTo(record::getActive)
                .set(idTeacher).equalTo(record::getIdTeacher)
                .set(idFile).equalTo(record::getIdFile);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-10T05:48:37.83729+01:00", comments="Source Table: course")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(Course record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(title).equalToWhenPresent(record::getTitle)
                .set(level).equalToWhenPresent(record::getLevel)
                .set(hours).equalToWhenPresent(record::getHours)
                .set(active).equalToWhenPresent(record::getActive)
                .set(idTeacher).equalToWhenPresent(record::getIdTeacher)
                .set(idFile).equalToWhenPresent(record::getIdFile);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-10T05:48:37.837523+01:00", comments="Source Table: course")
    default int updateByPrimaryKey(Course record) {
        return update(c ->
            c.set(title).equalTo(record::getTitle)
            .set(level).equalTo(record::getLevel)
            .set(hours).equalTo(record::getHours)
            .set(active).equalTo(record::getActive)
            .set(idTeacher).equalTo(record::getIdTeacher)
            .set(idFile).equalTo(record::getIdFile)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-10T05:48:37.837712+01:00", comments="Source Table: course")
    default int updateByPrimaryKeySelective(Course record) {
        return update(c ->
            c.set(title).equalToWhenPresent(record::getTitle)
            .set(level).equalToWhenPresent(record::getLevel)
            .set(hours).equalToWhenPresent(record::getHours)
            .set(active).equalToWhenPresent(record::getActive)
            .set(idTeacher).equalToWhenPresent(record::getIdTeacher)
            .set(idFile).equalToWhenPresent(record::getIdFile)
            .where(id, isEqualTo(record::getId))
        );
    }
}