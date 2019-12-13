package com.github.peacetrue.demo.service;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.dynamic.sql.SqlBuilder;
import org.mybatis.dynamic.sql.delete.DeleteDSL;
import org.mybatis.dynamic.sql.delete.MyBatis3DeleteModelAdapter;
import org.mybatis.dynamic.sql.delete.render.DeleteStatementProvider;
import org.mybatis.dynamic.sql.insert.render.InsertStatementProvider;
import org.mybatis.dynamic.sql.render.RenderingStrategy;
import org.mybatis.dynamic.sql.select.MyBatis3SelectModelAdapter;
import org.mybatis.dynamic.sql.select.QueryExpressionDSL;
import org.mybatis.dynamic.sql.select.SelectDSL;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.update.MyBatis3UpdateModelAdapter;
import org.mybatis.dynamic.sql.update.UpdateDSL;
import org.mybatis.dynamic.sql.update.render.UpdateStatementProvider;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;

import javax.annotation.Generated;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import static com.github.peacetrue.demo.service.DemoDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;
import static org.mybatis.dynamic.sql.SqlBuilder.isIn;

@Mapper
public interface DemoMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    long count(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @DeleteProvider(type = SqlProviderAdapter.class, method = "delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type = SqlProviderAdapter.class, method = "insert")
    @Options(useGeneratedKeys = true, keyProperty = "record.id")
    int insert(InsertStatementProvider<Demo> insertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    @ResultMap("DemoResult")
    Demo selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    @Results(id = "DemoResult", value = {
            @Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
            @Result(column = "code", property = "code", jdbcType = JdbcType.VARCHAR),
            @Result(column = "name", property = "name", jdbcType = JdbcType.VARCHAR),
            @Result(column = "creator_id", property = "creatorId", jdbcType = JdbcType.VARCHAR),
            @Result(column = "created_time", property = "createdTime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "modifier_id", property = "modifierId", jdbcType = JdbcType.VARCHAR),
            @Result(column = "modified_time", property = "modifiedTime", jdbcType = JdbcType.TIMESTAMP),
    })
    List<Demo> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @UpdateProvider(type = SqlProviderAdapter.class, method = "update")
    int update(UpdateStatementProvider updateStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<Long>> countByExample() {
        return SelectDSL.selectWithMapper(this::count, SqlBuilder.count())
                .from(demo);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default DeleteDSL<MyBatis3DeleteModelAdapter<Integer>> deleteByExample() {
        return DeleteDSL.deleteFromWithMapper(this::delete, demo);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Long id_) {
        return DeleteDSL.deleteFromWithMapper(this::delete, demo)
                .where(id, isEqualTo(id_))
                .build()
                .execute();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteInPrimaryKey(Collection<Long> id_) {
        return DeleteDSL.deleteFromWithMapper(this::delete, demo)
                .where(id, isIn(id_ instanceof List ? id_ : new LinkedList<>(id_)))
                .build()
                .execute();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(Demo record) {
        return insert(SqlBuilder.insert(record)
                .into(demo)
                .map(id).toProperty("id")
                .map(code).toProperty("code")
                .map(name).toProperty("name")
                .map(creatorId).toProperty("creatorId")
                .map(createdTime).toProperty("createdTime")
                .map(modifierId).toProperty("modifierId")
                .map(modifiedTime).toProperty("modifiedTime")
                .build()
                .render(RenderingStrategy.MYBATIS3));
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(Demo record) {
        return insert(SqlBuilder.insert(record)
                .into(demo)
                .map(id).toPropertyWhenPresent("id", record::getId)
                .map(code).toPropertyWhenPresent("code", record::getCode)
                .map(name).toPropertyWhenPresent("name", record::getName)
                .map(creatorId).toPropertyWhenPresent("creatorId", record::getCreatorId)
                .map(createdTime).toPropertyWhenPresent("createdTime", record::getCreatedTime)
                .map(modifierId).toPropertyWhenPresent("modifierId", record::getModifierId)
                .map(modifiedTime).toPropertyWhenPresent("modifiedTime", record::getModifiedTime)
                .build()
                .render(RenderingStrategy.MYBATIS3));
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<List<Demo>>> selectByExample() {
        return SelectDSL.selectWithMapper(this::selectMany, demo.column("*"))
                .from(demo);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<List<Demo>>> selectDistinctByExample() {
        return SelectDSL.selectDistinctWithMapper(this::selectMany, demo.column("*"))
                .from(demo);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Demo selectByPrimaryKey(Long id_) {
        return SelectDSL.selectWithMapper(this::selectOne, demo.column("*"))
                .from(demo)
                .where(id, isEqualTo(id_))
                .build()
                .execute();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default UpdateDSL<MyBatis3UpdateModelAdapter<Integer>> updateByExample(Demo record) {
        return UpdateDSL.updateWithMapper(this::update, demo)
                .set(id).equalTo(record::getId)
                .set(code).equalTo(record::getCode)
                .set(name).equalTo(record::getName)
                .set(creatorId).equalTo(record::getCreatorId)
                .set(createdTime).equalTo(record::getCreatedTime)
                .set(modifierId).equalTo(record::getModifierId)
                .set(modifiedTime).equalTo(record::getModifiedTime);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default UpdateDSL<MyBatis3UpdateModelAdapter<Integer>> updateByExampleSelective(Demo record) {
        return UpdateDSL.updateWithMapper(this::update, demo)
                .set(id).equalToWhenPresent(record::getId)
                .set(code).equalToWhenPresent(record::getCode)
                .set(name).equalToWhenPresent(record::getName)
                .set(creatorId).equalToWhenPresent(record::getCreatorId)
                .set(createdTime).equalToWhenPresent(record::getCreatedTime)
                .set(modifierId).equalToWhenPresent(record::getModifierId)
                .set(modifiedTime).equalToWhenPresent(record::getModifiedTime);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(Demo record) {
        return UpdateDSL.updateWithMapper(this::update, demo)
                .set(code).equalTo(record::getCode)
                .set(name).equalTo(record::getName)
                .set(creatorId).equalTo(record::getCreatorId)
                .set(createdTime).equalTo(record::getCreatedTime)
                .set(modifierId).equalTo(record::getModifierId)
                .set(modifiedTime).equalTo(record::getModifiedTime)
                .where(id, isEqualTo(record::getId))
                .build()
                .execute();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(Demo record) {
        return UpdateDSL.updateWithMapper(this::update, demo)
                .set(code).equalToWhenPresent(record::getCode)
                .set(name).equalToWhenPresent(record::getName)
                .set(creatorId).equalToWhenPresent(record::getCreatorId)
                .set(createdTime).equalToWhenPresent(record::getCreatedTime)
                .set(modifierId).equalToWhenPresent(record::getModifierId)
                .set(modifiedTime).equalToWhenPresent(record::getModifiedTime)
                .where(id, isEqualTo(record::getId))
                .build()
                .execute();
    }

    //append
    @SuppressWarnings("unchecked")
    default List<Demo> selectById(Collection<Long> ids) {
        return this.selectByExample().where(demo.id, SqlBuilder.isIn(new ArrayList<>(ids))).build().execute();
    }

}