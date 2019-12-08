package com.autentia.courses.persistence.mapper;

import com.autentia.courses.persistence.model.Teacher;
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

import static com.autentia.courses.persistence.mapper.TeacherDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

@Repository
@Mapper
public interface TeacherMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-05T04:07:51.880996+01:00", comments="Source Table: teacher")
    BasicColumn[] selectList = BasicColumn.columnList(id, firstName, lastName, age);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-05T04:07:51.869053+01:00", comments="Source Table: teacher")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-05T04:07:51.870144+01:00", comments="Source Table: teacher")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-05T04:07:51.870557+01:00", comments="Source Table: teacher")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<Teacher> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-05T04:07:51.871268+01:00", comments="Source Table: teacher")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<Teacher> multipleInsertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-05T04:07:51.871947+01:00", comments="Source Table: teacher")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("TeacherResult")
    Optional<Teacher> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-05T04:07:51.872901+01:00", comments="Source Table: teacher")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="TeacherResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="first_name", property="firstName", jdbcType=JdbcType.VARCHAR),
        @Result(column="last_name", property="lastName", jdbcType=JdbcType.VARCHAR),
        @Result(column="age", property="age", jdbcType=JdbcType.INTEGER)
    })
    List<Teacher> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-05T04:07:51.876054+01:00", comments="Source Table: teacher")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-05T04:07:51.876816+01:00", comments="Source Table: teacher")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, teacher, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-05T04:07:51.877201+01:00", comments="Source Table: teacher")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, teacher, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-05T04:07:51.877668+01:00", comments="Source Table: teacher")
    default int deleteByPrimaryKey(Integer id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-05T04:07:51.878165+01:00", comments="Source Table: teacher")
    default int insert(Teacher record) {
        return MyBatis3Utils.insert(this::insert, record, teacher, c ->
            c.map(id).toProperty("id")
            .map(firstName).toProperty("firstName")
            .map(lastName).toProperty("lastName")
            .map(age).toProperty("age")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-05T04:07:51.879266+01:00", comments="Source Table: teacher")
    default int insertMultiple(Collection<Teacher> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, teacher, c ->
            c.map(id).toProperty("id")
            .map(firstName).toProperty("firstName")
            .map(lastName).toProperty("lastName")
            .map(age).toProperty("age")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-05T04:07:51.879774+01:00", comments="Source Table: teacher")
    default int insertSelective(Teacher record) {
        return MyBatis3Utils.insert(this::insert, record, teacher, c ->
            c.map(id).toPropertyWhenPresent("id", record::getId)
            .map(firstName).toPropertyWhenPresent("firstName", record::getFirstName)
            .map(lastName).toPropertyWhenPresent("lastName", record::getLastName)
            .map(age).toPropertyWhenPresent("age", record::getAge)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-05T04:07:51.882058+01:00", comments="Source Table: teacher")
    default Optional<Teacher> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, teacher, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-05T04:07:51.882459+01:00", comments="Source Table: teacher")
    default List<Teacher> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, teacher, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-05T04:07:51.882836+01:00", comments="Source Table: teacher")
    default List<Teacher> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, teacher, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-05T04:07:51.883234+01:00", comments="Source Table: teacher")
    default Optional<Teacher> selectByPrimaryKey(Integer id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-05T04:07:51.883573+01:00", comments="Source Table: teacher")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, teacher, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-05T04:07:51.883947+01:00", comments="Source Table: teacher")
    static UpdateDSL<UpdateModel> updateAllColumns(Teacher record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(record::getId)
                .set(firstName).equalTo(record::getFirstName)
                .set(lastName).equalTo(record::getLastName)
                .set(age).equalTo(record::getAge);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-05T04:07:51.884424+01:00", comments="Source Table: teacher")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(Teacher record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(record::getId)
                .set(firstName).equalToWhenPresent(record::getFirstName)
                .set(lastName).equalToWhenPresent(record::getLastName)
                .set(age).equalToWhenPresent(record::getAge);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-05T04:07:51.885119+01:00", comments="Source Table: teacher")
    default int updateByPrimaryKey(Teacher record) {
        return update(c ->
            c.set(firstName).equalTo(record::getFirstName)
            .set(lastName).equalTo(record::getLastName)
            .set(age).equalTo(record::getAge)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-05T04:07:51.885584+01:00", comments="Source Table: teacher")
    default int updateByPrimaryKeySelective(Teacher record) {
        return update(c ->
            c.set(firstName).equalToWhenPresent(record::getFirstName)
            .set(lastName).equalToWhenPresent(record::getLastName)
            .set(age).equalToWhenPresent(record::getAge)
            .where(id, isEqualTo(record::getId))
        );
    }
}