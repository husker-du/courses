package com.autentia.courses.persistence.mapper;

import static com.autentia.courses.persistence.mapper.TeacherDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.autentia.courses.persistence.model.Teacher;
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
public interface TeacherMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-10T05:48:37.82658+01:00", comments="Source Table: teacher")
    BasicColumn[] selectList = BasicColumn.columnList(id, firstName, lastName, age);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-10T05:48:37.816185+01:00", comments="Source Table: teacher")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-10T05:48:37.817612+01:00", comments="Source Table: teacher")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-10T05:48:37.818024+01:00", comments="Source Table: teacher")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="record.id", before=false, resultType=Integer.class)
    int insert(InsertStatementProvider<Teacher> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-10T05:48:37.820601+01:00", comments="Source Table: teacher")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("TeacherResult")
    Optional<Teacher> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-10T05:48:37.821067+01:00", comments="Source Table: teacher")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="TeacherResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="first_name", property="firstName", jdbcType=JdbcType.VARCHAR),
        @Result(column="last_name", property="lastName", jdbcType=JdbcType.VARCHAR),
        @Result(column="age", property="age", jdbcType=JdbcType.INTEGER)
    })
    List<Teacher> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-10T05:48:37.821967+01:00", comments="Source Table: teacher")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-10T05:48:37.822332+01:00", comments="Source Table: teacher")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, teacher, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-10T05:48:37.822838+01:00", comments="Source Table: teacher")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, teacher, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-10T05:48:37.823234+01:00", comments="Source Table: teacher")
    default int deleteByPrimaryKey(Integer id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-10T05:48:37.823792+01:00", comments="Source Table: teacher")
    default int insert(Teacher record) {
        return MyBatis3Utils.insert(this::insert, record, teacher, c ->
            c.map(firstName).toProperty("firstName")
            .map(lastName).toProperty("lastName")
            .map(age).toProperty("age")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-10T05:48:37.825355+01:00", comments="Source Table: teacher")
    default int insertSelective(Teacher record) {
        return MyBatis3Utils.insert(this::insert, record, teacher, c ->
            c.map(firstName).toPropertyWhenPresent("firstName", record::getFirstName)
            .map(lastName).toPropertyWhenPresent("lastName", record::getLastName)
            .map(age).toPropertyWhenPresent("age", record::getAge)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-10T05:48:37.827645+01:00", comments="Source Table: teacher")
    default Optional<Teacher> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, teacher, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-10T05:48:37.82801+01:00", comments="Source Table: teacher")
    default List<Teacher> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, teacher, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-10T05:48:37.828559+01:00", comments="Source Table: teacher")
    default List<Teacher> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, teacher, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-10T05:48:37.829124+01:00", comments="Source Table: teacher")
    default Optional<Teacher> selectByPrimaryKey(Integer id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-10T05:48:37.829515+01:00", comments="Source Table: teacher")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, teacher, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-10T05:48:37.829898+01:00", comments="Source Table: teacher")
    static UpdateDSL<UpdateModel> updateAllColumns(Teacher record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(firstName).equalTo(record::getFirstName)
                .set(lastName).equalTo(record::getLastName)
                .set(age).equalTo(record::getAge);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-10T05:48:37.83037+01:00", comments="Source Table: teacher")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(Teacher record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(firstName).equalToWhenPresent(record::getFirstName)
                .set(lastName).equalToWhenPresent(record::getLastName)
                .set(age).equalToWhenPresent(record::getAge);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-10T05:48:37.831107+01:00", comments="Source Table: teacher")
    default int updateByPrimaryKey(Teacher record) {
        return update(c ->
            c.set(firstName).equalTo(record::getFirstName)
            .set(lastName).equalTo(record::getLastName)
            .set(age).equalTo(record::getAge)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-10T05:48:37.831773+01:00", comments="Source Table: teacher")
    default int updateByPrimaryKeySelective(Teacher record) {
        return update(c ->
            c.set(firstName).equalToWhenPresent(record::getFirstName)
            .set(lastName).equalToWhenPresent(record::getLastName)
            .set(age).equalToWhenPresent(record::getAge)
            .where(id, isEqualTo(record::getId))
        );
    }
}