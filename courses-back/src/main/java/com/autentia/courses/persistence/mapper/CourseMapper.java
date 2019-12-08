package com.autentia.courses.persistence.mapper;

import com.autentia.courses.persistence.model.Course;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.dynamic.sql.BasicColumn;
import org.mybatis.dynamic.sql.delete.DeleteDSLCompleter;
import org.mybatis.dynamic.sql.delete.render.DeleteStatementProvider;
import org.mybatis.dynamic.sql.insert.render.InsertStatementProvider;
import org.mybatis.dynamic.sql.insert.render.MultiRowInsertStatementProvider;
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

import javax.annotation.Generated;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import static com.autentia.courses.persistence.mapper.CourseDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

@Repository
@Mapper
public interface CourseMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-05T04:07:51.889613+01:00", comments="Source Table: course")
    BasicColumn[] selectList = BasicColumn.columnList(id, title, level, hours, active, idTeacher);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-05T04:07:51.888554+01:00", comments="Source Table: course")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-05T04:07:51.88861+01:00", comments="Source Table: course")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-05T04:07:51.888663+01:00", comments="Source Table: course")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<Course> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-05T04:07:51.888735+01:00", comments="Source Table: course")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<Course> multipleInsertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-05T04:07:51.888795+01:00", comments="Source Table: course")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("CourseResult")
    Optional<Course> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-05T04:07:51.888863+01:00", comments="Source Table: course")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="CourseResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="level", property="level", jdbcType=JdbcType.VARCHAR),
        @Result(column="hours", property="hours", jdbcType=JdbcType.INTEGER),
        @Result(column="active", property="active", jdbcType=JdbcType.TINYINT),
        @Result(column="id_teacher", property="idTeacher", jdbcType=JdbcType.INTEGER)
    })
    List<Course> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-05T04:07:51.888974+01:00", comments="Source Table: course")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-05T04:07:51.889034+01:00", comments="Source Table: course")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, course, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-05T04:07:51.88915+01:00", comments="Source Table: course")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, course, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-05T04:07:51.889216+01:00", comments="Source Table: course")
    default int deleteByPrimaryKey(Integer id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-05T04:07:51.889283+01:00", comments="Source Table: course")
    default int insert(Course record) {
        return MyBatis3Utils.insert(this::insert, record, course, c ->
            c.map(id).toProperty("id")
            .map(title).toProperty("title")
            .map(level).toProperty("level")
            .map(hours).toProperty("hours")
            .map(active).toProperty("active")
            .map(idTeacher).toProperty("idTeacher")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-05T04:07:51.88938+01:00", comments="Source Table: course")
    default int insertMultiple(Collection<Course> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, course, c ->
            c.map(id).toProperty("id")
            .map(title).toProperty("title")
            .map(level).toProperty("level")
            .map(hours).toProperty("hours")
            .map(active).toProperty("active")
            .map(idTeacher).toProperty("idTeacher")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-05T04:07:51.889472+01:00", comments="Source Table: course")
    default int insertSelective(Course record) {
        return MyBatis3Utils.insert(this::insert, record, course, c ->
            c.map(id).toPropertyWhenPresent("id", record::getId)
            .map(title).toPropertyWhenPresent("title", record::getTitle)
            .map(level).toPropertyWhenPresent("level", record::getLevel)
            .map(hours).toPropertyWhenPresent("hours", record::getHours)
            .map(active).toPropertyWhenPresent("active", record::getActive)
            .map(idTeacher).toPropertyWhenPresent("idTeacher", record::getIdTeacher)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-05T04:07:51.889673+01:00", comments="Source Table: course")
    default Optional<Course> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, course, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-05T04:07:51.889729+01:00", comments="Source Table: course")
    default List<Course> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, course, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-05T04:07:51.889783+01:00", comments="Source Table: course")
    default List<Course> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, course, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-05T04:07:51.889843+01:00", comments="Source Table: course")
    default Optional<Course> selectByPrimaryKey(Integer id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-05T04:07:51.889902+01:00", comments="Source Table: course")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, course, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-05T04:07:51.88996+01:00", comments="Source Table: course")
    static UpdateDSL<UpdateModel> updateAllColumns(Course record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(record::getId)
                .set(title).equalTo(record::getTitle)
                .set(level).equalTo(record::getLevel)
                .set(hours).equalTo(record::getHours)
                .set(active).equalTo(record::getActive)
                .set(idTeacher).equalTo(record::getIdTeacher);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-05T04:07:51.890067+01:00", comments="Source Table: course")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(Course record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(record::getId)
                .set(title).equalToWhenPresent(record::getTitle)
                .set(level).equalToWhenPresent(record::getLevel)
                .set(hours).equalToWhenPresent(record::getHours)
                .set(active).equalToWhenPresent(record::getActive)
                .set(idTeacher).equalToWhenPresent(record::getIdTeacher);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-05T04:07:51.890191+01:00", comments="Source Table: course")
    default int updateByPrimaryKey(Course record) {
        return update(c ->
            c.set(title).equalTo(record::getTitle)
            .set(level).equalTo(record::getLevel)
            .set(hours).equalTo(record::getHours)
            .set(active).equalTo(record::getActive)
            .set(idTeacher).equalTo(record::getIdTeacher)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-05T04:07:51.890312+01:00", comments="Source Table: course")
    default int updateByPrimaryKeySelective(Course record) {
        return update(c ->
            c.set(title).equalToWhenPresent(record::getTitle)
            .set(level).equalToWhenPresent(record::getLevel)
            .set(hours).equalToWhenPresent(record::getHours)
            .set(active).equalToWhenPresent(record::getActive)
            .set(idTeacher).equalToWhenPresent(record::getIdTeacher)
            .where(id, isEqualTo(record::getId))
        );
    }
}