/*
 * Auto-generated file. Created by MyBatis Generator
 */
package jp.co.azureplus.purchase_app.infrastructure.database.mapper.generated

import jp.co.azureplus.purchase_app.infrastructure.database.mapper.generated.ApplicationDynamicSqlSupport.Application
import jp.co.azureplus.purchase_app.infrastructure.database.mapper.generated.ApplicationDynamicSqlSupport.Application.appDate
import jp.co.azureplus.purchase_app.infrastructure.database.mapper.generated.ApplicationDynamicSqlSupport.Application.confirmId
import jp.co.azureplus.purchase_app.infrastructure.database.mapper.generated.ApplicationDynamicSqlSupport.Application.productId
import jp.co.azureplus.purchase_app.infrastructure.database.mapper.generated.ApplicationDynamicSqlSupport.Application.reason
import jp.co.azureplus.purchase_app.infrastructure.database.mapper.generated.ApplicationDynamicSqlSupport.Application.userId
import jp.co.azureplus.purchase_app.infrastructure.database.record.generated.ApplicationRecord
import org.mybatis.dynamic.sql.SqlBuilder.isEqualTo
import org.mybatis.dynamic.sql.util.kotlin.*
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.*

fun ApplicationMapper.count(completer: CountCompleter) =
    countFrom(this::count, Application, completer)

fun ApplicationMapper.delete(completer: DeleteCompleter) =
    deleteFrom(this::delete, Application, completer)

fun ApplicationMapper.deleteByPrimaryKey(userId_: Long, confirmId_: Long) =
    delete {
        where(userId, isEqualTo(userId_))
        and(confirmId, isEqualTo(confirmId_))
    }

fun ApplicationMapper.insert(record: ApplicationRecord) =
    insert(this::insert, record, Application) {
        map(userId).toProperty("userId")
        map(confirmId).toProperty("confirmId")
        map(reason).toProperty("reason")
        map(appDate).toProperty("appDate")
        map(productId).toProperty("productId")
    }

fun ApplicationMapper.insertMultiple(records: Collection<ApplicationRecord>) =
    insertMultiple(this::insertMultiple, records, Application) {
        map(userId).toProperty("userId")
        map(confirmId).toProperty("confirmId")
        map(reason).toProperty("reason")
        map(appDate).toProperty("appDate")
        map(productId).toProperty("productId")
    }

fun ApplicationMapper.insertMultiple(vararg records: ApplicationRecord) =
    insertMultiple(records.toList())

fun ApplicationMapper.insertSelective(record: ApplicationRecord) =
    insert(this::insert, record, Application) {
        map(userId).toPropertyWhenPresent("userId", record::userId)
        map(confirmId).toPropertyWhenPresent("confirmId", record::confirmId)
        map(reason).toPropertyWhenPresent("reason", record::reason)
        map(appDate).toPropertyWhenPresent("appDate", record::appDate)
        map(productId).toPropertyWhenPresent("productId", record::productId)
    }

private val columnList = listOf(userId, confirmId, reason, appDate, productId)

fun ApplicationMapper.selectOne(completer: SelectCompleter) =
    selectOne(this::selectOne, columnList, Application, completer)

fun ApplicationMapper.select(completer: SelectCompleter) =
    selectList(this::selectMany, columnList, Application, completer)

fun ApplicationMapper.selectDistinct(completer: SelectCompleter) =
    selectDistinct(this::selectMany, columnList, Application, completer)

fun ApplicationMapper.selectByPrimaryKey(userId_: Long, confirmId_: Long) =
    selectOne {
        where(userId, isEqualTo(userId_))
        and(confirmId, isEqualTo(confirmId_))
    }

fun ApplicationMapper.update(completer: UpdateCompleter) =
    update(this::update, Application, completer)

fun KotlinUpdateBuilder.updateAllColumns(record: ApplicationRecord) =
    apply {
        set(userId).equalTo(record::userId)
        set(confirmId).equalTo(record::confirmId)
        set(reason).equalTo(record::reason)
        set(appDate).equalTo(record::appDate)
        set(productId).equalTo(record::productId)
    }

fun KotlinUpdateBuilder.updateSelectiveColumns(record: ApplicationRecord) =
    apply {
        set(userId).equalToWhenPresent(record::userId)
        set(confirmId).equalToWhenPresent(record::confirmId)
        set(reason).equalToWhenPresent(record::reason)
        set(appDate).equalToWhenPresent(record::appDate)
        set(productId).equalToWhenPresent(record::productId)
    }

fun ApplicationMapper.updateByPrimaryKey(record: ApplicationRecord) =
    update {
        set(reason).equalTo(record::reason)
        set(appDate).equalTo(record::appDate)
        set(productId).equalTo(record::productId)
        where(userId, isEqualTo(record::userId))
        and(confirmId, isEqualTo(record::confirmId))
    }

fun ApplicationMapper.updateByPrimaryKeySelective(record: ApplicationRecord) =
    update {
        set(reason).equalToWhenPresent(record::reason)
        set(appDate).equalToWhenPresent(record::appDate)
        set(productId).equalToWhenPresent(record::productId)
        where(userId, isEqualTo(record::userId))
        and(confirmId, isEqualTo(record::confirmId))
    }