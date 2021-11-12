/*
 * Auto-generated file. Created by MyBatis Generator
 */
package jp.co.azureplus.purchase_app.infrastructure.database.mapper.generated

import jp.co.azureplus.purchase_app.infrastructure.database.mapper.generated.RoleDynamicSqlSupport.Role
import jp.co.azureplus.purchase_app.infrastructure.database.mapper.generated.RoleDynamicSqlSupport.Role.roleId
import jp.co.azureplus.purchase_app.infrastructure.database.mapper.generated.RoleDynamicSqlSupport.Role.roleType
import jp.co.azureplus.purchase_app.infrastructure.database.record.generated.RoleRecord
import org.mybatis.dynamic.sql.SqlBuilder.isEqualTo
import org.mybatis.dynamic.sql.util.kotlin.*
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.*

fun RoleMapper.count(completer: CountCompleter) =
    countFrom(this::count, Role, completer)

fun RoleMapper.delete(completer: DeleteCompleter) =
    deleteFrom(this::delete, Role, completer)

fun RoleMapper.deleteByPrimaryKey(roleId_: Long) =
    delete {
        where(roleId, isEqualTo(roleId_))
    }

fun RoleMapper.insert(record: RoleRecord) =
    insert(this::insert, record, Role) {
        map(roleId).toProperty("roleId")
        map(roleType).toProperty("roleType")
    }

fun RoleMapper.insertMultiple(records: Collection<RoleRecord>) =
    insertMultiple(this::insertMultiple, records, Role) {
        map(roleId).toProperty("roleId")
        map(roleType).toProperty("roleType")
    }

fun RoleMapper.insertMultiple(vararg records: RoleRecord) =
    insertMultiple(records.toList())

fun RoleMapper.insertSelective(record: RoleRecord) =
    insert(this::insert, record, Role) {
        map(roleId).toPropertyWhenPresent("roleId", record::roleId)
        map(roleType).toPropertyWhenPresent("roleType", record::roleType)
    }

private val columnList = listOf(roleId, roleType)

fun RoleMapper.selectOne(completer: SelectCompleter) =
    selectOne(this::selectOne, columnList, Role, completer)

fun RoleMapper.select(completer: SelectCompleter) =
    selectList(this::selectMany, columnList, Role, completer)

fun RoleMapper.selectDistinct(completer: SelectCompleter) =
    selectDistinct(this::selectMany, columnList, Role, completer)

fun RoleMapper.selectByPrimaryKey(roleId_: Long) =
    selectOne {
        where(roleId, isEqualTo(roleId_))
    }

fun RoleMapper.update(completer: UpdateCompleter) =
    update(this::update, Role, completer)

fun KotlinUpdateBuilder.updateAllColumns(record: RoleRecord) =
    apply {
        set(roleId).equalTo(record::roleId)
        set(roleType).equalTo(record::roleType)
    }

fun KotlinUpdateBuilder.updateSelectiveColumns(record: RoleRecord) =
    apply {
        set(roleId).equalToWhenPresent(record::roleId)
        set(roleType).equalToWhenPresent(record::roleType)
    }

fun RoleMapper.updateByPrimaryKey(record: RoleRecord) =
    update {
        set(roleType).equalTo(record::roleType)
        where(roleId, isEqualTo(record::roleId))
    }

fun RoleMapper.updateByPrimaryKeySelective(record: RoleRecord) =
    update {
        set(roleType).equalToWhenPresent(record::roleType)
        where(roleId, isEqualTo(record::roleId))
    }