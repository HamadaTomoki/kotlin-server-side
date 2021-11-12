/*
 * Auto-generated file. Created by MyBatis Generator
 */
package jp.co.azureplus.purchase_app.infrastructure.database.mapper.generated

import jp.co.azureplus.purchase_app.infrastructure.database.mapper.generated.ProviderDynamicSqlSupport.Provider
import jp.co.azureplus.purchase_app.infrastructure.database.mapper.generated.ProviderDynamicSqlSupport.Provider.name
import jp.co.azureplus.purchase_app.infrastructure.database.mapper.generated.ProviderDynamicSqlSupport.Provider.providerId
import jp.co.azureplus.purchase_app.infrastructure.database.record.generated.ProviderRecord
import org.mybatis.dynamic.sql.SqlBuilder.isEqualTo
import org.mybatis.dynamic.sql.util.kotlin.*
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.*

fun ProviderMapper.count(completer: CountCompleter) =
    countFrom(this::count, Provider, completer)

fun ProviderMapper.delete(completer: DeleteCompleter) =
    deleteFrom(this::delete, Provider, completer)

fun ProviderMapper.deleteByPrimaryKey(providerId_: Long) =
    delete {
        where(providerId, isEqualTo(providerId_))
    }

fun ProviderMapper.insert(record: ProviderRecord) =
    insert(this::insert, record, Provider) {
        map(providerId).toProperty("providerId")
        map(name).toProperty("name")
    }

fun ProviderMapper.insertMultiple(records: Collection<ProviderRecord>) =
    insertMultiple(this::insertMultiple, records, Provider) {
        map(providerId).toProperty("providerId")
        map(name).toProperty("name")
    }

fun ProviderMapper.insertMultiple(vararg records: ProviderRecord) =
    insertMultiple(records.toList())

fun ProviderMapper.insertSelective(record: ProviderRecord) =
    insert(this::insert, record, Provider) {
        map(providerId).toPropertyWhenPresent("providerId", record::providerId)
        map(name).toPropertyWhenPresent("name", record::name)
    }

private val columnList = listOf(providerId, name)

fun ProviderMapper.selectOne(completer: SelectCompleter) =
    selectOne(this::selectOne, columnList, Provider, completer)

fun ProviderMapper.select(completer: SelectCompleter) =
    selectList(this::selectMany, columnList, Provider, completer)

fun ProviderMapper.selectDistinct(completer: SelectCompleter) =
    selectDistinct(this::selectMany, columnList, Provider, completer)

fun ProviderMapper.selectByPrimaryKey(providerId_: Long) =
    selectOne {
        where(providerId, isEqualTo(providerId_))
    }

fun ProviderMapper.update(completer: UpdateCompleter) =
    update(this::update, Provider, completer)

fun KotlinUpdateBuilder.updateAllColumns(record: ProviderRecord) =
    apply {
        set(providerId).equalTo(record::providerId)
        set(name).equalTo(record::name)
    }

fun KotlinUpdateBuilder.updateSelectiveColumns(record: ProviderRecord) =
    apply {
        set(providerId).equalToWhenPresent(record::providerId)
        set(name).equalToWhenPresent(record::name)
    }

fun ProviderMapper.updateByPrimaryKey(record: ProviderRecord) =
    update {
        set(name).equalTo(record::name)
        where(providerId, isEqualTo(record::providerId))
    }

fun ProviderMapper.updateByPrimaryKeySelective(record: ProviderRecord) =
    update {
        set(name).equalToWhenPresent(record::name)
        where(providerId, isEqualTo(record::providerId))
    }