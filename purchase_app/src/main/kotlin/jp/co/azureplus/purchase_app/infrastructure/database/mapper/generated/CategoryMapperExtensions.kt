/*
 * Auto-generated file. Created by MyBatis Generator
 */
package jp.co.azureplus.purchase_app.infrastructure.database.mapper.generated

import jp.co.azureplus.purchase_app.infrastructure.database.mapper.generated.CategoryDynamicSqlSupport.Category
import jp.co.azureplus.purchase_app.infrastructure.database.mapper.generated.CategoryDynamicSqlSupport.Category.categoryId
import jp.co.azureplus.purchase_app.infrastructure.database.mapper.generated.CategoryDynamicSqlSupport.Category.name
import jp.co.azureplus.purchase_app.infrastructure.database.record.generated.CategoryRecord
import org.mybatis.dynamic.sql.SqlBuilder.isEqualTo
import org.mybatis.dynamic.sql.util.kotlin.*
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.*

fun CategoryMapper.count(completer: CountCompleter) =
    countFrom(this::count, Category, completer)

fun CategoryMapper.delete(completer: DeleteCompleter) =
    deleteFrom(this::delete, Category, completer)

fun CategoryMapper.deleteByPrimaryKey(categoryId_: Long) =
    delete {
        where(categoryId, isEqualTo(categoryId_))
    }

fun CategoryMapper.insert(record: CategoryRecord) =
    insert(this::insert, record, Category) {
        map(categoryId).toProperty("categoryId")
        map(name).toProperty("name")
    }

fun CategoryMapper.insertMultiple(records: Collection<CategoryRecord>) =
    insertMultiple(this::insertMultiple, records, Category) {
        map(categoryId).toProperty("categoryId")
        map(name).toProperty("name")
    }

fun CategoryMapper.insertMultiple(vararg records: CategoryRecord) =
    insertMultiple(records.toList())

fun CategoryMapper.insertSelective(record: CategoryRecord) =
    insert(this::insert, record, Category) {
        map(categoryId).toPropertyWhenPresent("categoryId", record::categoryId)
        map(name).toPropertyWhenPresent("name", record::name)
    }

private val columnList = listOf(categoryId, name)

fun CategoryMapper.selectOne(completer: SelectCompleter) =
    selectOne(this::selectOne, columnList, Category, completer)

fun CategoryMapper.select(completer: SelectCompleter) =
    selectList(this::selectMany, columnList, Category, completer)

fun CategoryMapper.selectDistinct(completer: SelectCompleter) =
    selectDistinct(this::selectMany, columnList, Category, completer)

fun CategoryMapper.selectByPrimaryKey(categoryId_: Long) =
    selectOne {
        where(categoryId, isEqualTo(categoryId_))
    }

fun CategoryMapper.update(completer: UpdateCompleter) =
    update(this::update, Category, completer)

fun KotlinUpdateBuilder.updateAllColumns(record: CategoryRecord) =
    apply {
        set(categoryId).equalTo(record::categoryId)
        set(name).equalTo(record::name)
    }

fun KotlinUpdateBuilder.updateSelectiveColumns(record: CategoryRecord) =
    apply {
        set(categoryId).equalToWhenPresent(record::categoryId)
        set(name).equalToWhenPresent(record::name)
    }

fun CategoryMapper.updateByPrimaryKey(record: CategoryRecord) =
    update {
        set(name).equalTo(record::name)
        where(categoryId, isEqualTo(record::categoryId))
    }

fun CategoryMapper.updateByPrimaryKeySelective(record: CategoryRecord) =
    update {
        set(name).equalToWhenPresent(record::name)
        where(categoryId, isEqualTo(record::categoryId))
    }