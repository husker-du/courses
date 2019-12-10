package com.autentia.courses.persistence.mapper;

import static com.autentia.courses.persistence.mapper.SubjectFileDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.autentia.courses.persistence.model.SubjectFile;
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
public interface SubjectFileMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-10T14:23:36.965389+01:00", comments="Source Table: subject_file")
    BasicColumn[] selectList = BasicColumn.columnList(id, fileName, type, data);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-10T14:23:36.964637+01:00", comments="Source Table: subject_file")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-10T14:23:36.964691+01:00", comments="Source Table: subject_file")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-10T14:23:36.964737+01:00", comments="Source Table: subject_file")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="record.id", before=false, resultType=Integer.class)
    int insert(InsertStatementProvider<SubjectFile> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-10T14:23:36.964825+01:00", comments="Source Table: subject_file")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("SubjectFileResult")
    Optional<SubjectFile> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-10T14:23:36.964882+01:00", comments="Source Table: subject_file")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="SubjectFileResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="file_name", property="fileName", jdbcType=JdbcType.VARCHAR),
        @Result(column="type", property="type", jdbcType=JdbcType.VARCHAR),
        @Result(column="data", property="data", jdbcType=JdbcType.LONGVARBINARY)
    })
    List<SubjectFile> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-10T14:23:36.964967+01:00", comments="Source Table: subject_file")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-10T14:23:36.965015+01:00", comments="Source Table: subject_file")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, subjectFile, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-10T14:23:36.96507+01:00", comments="Source Table: subject_file")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, subjectFile, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-10T14:23:36.965114+01:00", comments="Source Table: subject_file")
    default int deleteByPrimaryKey(Integer id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-10T14:23:36.965162+01:00", comments="Source Table: subject_file")
    default int insert(SubjectFile record) {
        return MyBatis3Utils.insert(this::insert, record, subjectFile, c ->
            c.map(fileName).toProperty("fileName")
            .map(type).toProperty("type")
            .map(data).toProperty("data")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-10T14:23:36.965256+01:00", comments="Source Table: subject_file")
    default int insertSelective(SubjectFile record) {
        return MyBatis3Utils.insert(this::insert, record, subjectFile, c ->
            c.map(fileName).toPropertyWhenPresent("fileName", record::getFileName)
            .map(type).toPropertyWhenPresent("type", record::getType)
            .map(data).toPropertyWhenPresent("data", record::getData)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-10T14:23:36.965439+01:00", comments="Source Table: subject_file")
    default Optional<SubjectFile> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, subjectFile, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-10T14:23:36.965488+01:00", comments="Source Table: subject_file")
    default List<SubjectFile> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, subjectFile, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-10T14:23:36.965535+01:00", comments="Source Table: subject_file")
    default List<SubjectFile> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, subjectFile, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-10T14:23:36.965588+01:00", comments="Source Table: subject_file")
    default Optional<SubjectFile> selectByPrimaryKey(Integer id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-10T14:23:36.965649+01:00", comments="Source Table: subject_file")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, subjectFile, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-10T14:23:36.965696+01:00", comments="Source Table: subject_file")
    static UpdateDSL<UpdateModel> updateAllColumns(SubjectFile record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(fileName).equalTo(record::getFileName)
                .set(type).equalTo(record::getType)
                .set(data).equalTo(record::getData);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-10T14:23:36.965783+01:00", comments="Source Table: subject_file")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(SubjectFile record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(fileName).equalToWhenPresent(record::getFileName)
                .set(type).equalToWhenPresent(record::getType)
                .set(data).equalToWhenPresent(record::getData);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-10T14:23:36.96589+01:00", comments="Source Table: subject_file")
    default int updateByPrimaryKey(SubjectFile record) {
        return update(c ->
            c.set(fileName).equalTo(record::getFileName)
            .set(type).equalTo(record::getType)
            .set(data).equalTo(record::getData)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-10T14:23:36.966041+01:00", comments="Source Table: subject_file")
    default int updateByPrimaryKeySelective(SubjectFile record) {
        return update(c ->
            c.set(fileName).equalToWhenPresent(record::getFileName)
            .set(type).equalToWhenPresent(record::getType)
            .set(data).equalToWhenPresent(record::getData)
            .where(id, isEqualTo(record::getId))
        );
    }
}