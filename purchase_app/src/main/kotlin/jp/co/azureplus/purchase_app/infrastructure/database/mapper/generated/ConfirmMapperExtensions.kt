/*
 * Auto-generated file. Created by MyBatis Generator
 */
package jp.co.azureplus.purchase_app.infrastructure.database.mapper.generated

import jp.co.azureplus.purchase_app.infrastructure.database.mapper.generated.ConfirmDynamicSqlSupport.Confirm
import jp.co.azureplus.purchase_app.infrastructure.database.mapper.generated.ConfirmDynamicSqlSupport.Confirm.confirmDate
import jp.co.azureplus.purchase_app.infrastructure.database.mapper.generated.ConfirmDynamicSqlSupport.Confirm.confirmId
import jp.co.azureplus.purchase_app.infrastructure.database.mapper.generated.ConfirmDynamicSqlSupport.Confirm.confirmStatus
import jp.co.azureplus.purchase_app.infrastructure.database.mapper.generated.ConfirmDynamicSqlSupport.Confirm.reason
import jp.co.azureplus.purchase_app.infrastructure.database.record.generated.ConfirmRecord
import org.mybatis.dynamic.sql.SqlBuilder.isEqualTo
import org.mybatis.dynamic.sql.util.kotlin.*
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.*

fun ConfirmMapper.count(completer: CountCompleter) =
    countFrom(this::count, Confirm, completer)

fun ConfirmMapper.delete(completer: DeleteCompleter) =
    deleteFrom(this::delete, Confirm, completer)

fun ConfirmMapper.deleteByPrimaryKey(confirmId_: Long) =
    delete {
        where(confirmId, isEqualTo(confirmId_))
    }

fun ConfirmMapper.insert(record: ConfirmRecord) =
    insert(this::insert, record, Confirm) {
        map(confirmId).toProperty("confirmId")
        map(confirmDate).toProperty("confirmDate")
        map(confirmStatus).toProperty("confirmStatus")
        map(reason).toProperty("reason")
    }

fun ConfirmMapper.insertMultiple(records: Collection<ConfirmRecord>) =
    insertMultiple(this::insertMultiple, records, Confirm) {
        map(confirmId).toProperty("confirmId")
        map(confirmDate).toProperty("confirmDate")
        map(confirmStatus).toProperty("confirmStatus")
        map(reason).toProperty("reason")
    }

fun ConfirmMapper.insertMultiple(vararg records: ConfirmRecord) =
    insertMultiple(records.toList())

fun ConfirmMapper.insertSelective(record: ConfirmRecord) =
    insert(this::insert, record, Confirm) {
        map(confirmId).toPropertyWhenPresent("confirmId", record::confirmId)
        map(confirmDate).toPropertyWhenPresent("confirmDate", record::confirmDate)
        map(confirmStatus).toPropertyWhenPresent("confirmStatus", record::confirmStatus)
        map(reason).toPropertyWhenPresent("reason", record::reason)
    }

private val columnList = listOf(confirmId, confirmDate, confirmStatus, reason)

fun ConfirmMapper.selectOne(completer: SelectCompleter) =
    selectOne(this::selectOne, columnList, Confirm, completer)

fun ConfirmMapper.select(completer: SelectCompleter) =
    selectList(this::selectMany, columnList, Confirm, completer)

fun ConfirmMapper.selectDistinct(completer: SelectCompleter) =
    selectDistinct(this::selectMany, columnList, Confirm, completer)

fun ConfirmMapper.selectByPrimaryKey(confirmId_: Long) =
    selectOne {
        where(confirmId, isEqualTo(confirmId_))
    }

fun ConfirmMapper.update(completer: UpdateCompleter) =
    update(this::update, Confirm, completer)

fun KotlinUpdateBuilder.updateAllColumns(record: ConfirmRecord) =
    apply {
        set(confirmId).equalTo(record::confirmId)
        set(confirmDate).equalTo(record::confirmDate)
        set(confirmStatus).equalTo(record::confirmStatus)
        set(reason).equalTo(record::reason)
    }

fun KotlinUpdateBuilder.updateSelectiveColumns(record: ConfirmRecord) =
    apply {
        set(confirmId).equalToWhenPresent(record::confirmId)
        set(confirmDate).equalToWhenPresent(record::confirmDate)
        set(confirmStatus).equalToWhenPresent(record::confirmStatus)
        set(reason).equalToWhenPresent(record::reason)
    }

fun ConfirmMapper.updateByPrimaryKey(record: ConfirmRecord) =
    update {
        set(confirmDate).equalTo(record::confirmDate)
        set(confirmStatus).equalTo(record::confirmStatus)
        set(reason).equalTo(record::reason)
        where(confirmId, isEqualTo(record::confirmId))
    }

fun ConfirmMapper.updateByPrimaryKeySelective(record: ConfirmRecord) =
    update {
        set(confirmDate).equalToWhenPresent(record::confirmDate)
        set(confirmStatus).equalToWhenPresent(record::confirmStatus)
        set(reason).equalToWhenPresent(record::reason)
        where(confirmId, isEqualTo(record::confirmId))
    }