/*
 * Auto-generated file. Created by MyBatis Generator
 */
package jp.co.azureplus.purchase_app.infrastructure.database.mapper.generated

import jp.co.azureplus.purchase_app.infrastructure.database.mapper.generated.UserDynamicSqlSupport.User
import jp.co.azureplus.purchase_app.infrastructure.database.mapper.generated.UserDynamicSqlSupport.User.email
import jp.co.azureplus.purchase_app.infrastructure.database.mapper.generated.UserDynamicSqlSupport.User.name
import jp.co.azureplus.purchase_app.infrastructure.database.mapper.generated.UserDynamicSqlSupport.User.password
import jp.co.azureplus.purchase_app.infrastructure.database.mapper.generated.UserDynamicSqlSupport.User.roleId
import jp.co.azureplus.purchase_app.infrastructure.database.mapper.generated.UserDynamicSqlSupport.User.userId
import jp.co.azureplus.purchase_app.infrastructure.database.record.generated.UserRecord
import org.mybatis.dynamic.sql.SqlBuilder.isEqualTo
import org.mybatis.dynamic.sql.util.kotlin.*
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.*

fun UserMapper.count(completer: CountCompleter) =
    countFrom(this::count, User, completer)

fun UserMapper.delete(completer: DeleteCompleter) =
    deleteFrom(this::delete, User, completer)

fun UserMapper.deleteByPrimaryKey(userId_: Long) =
    delete {
        where(userId, isEqualTo(userId_))
    }

fun UserMapper.insert(record: UserRecord) =
    insert(this::insert, record, User) {
        map(userId).toProperty("userId")
        map(name).toProperty("name")
        map(email).toProperty("email")
        map(password).toProperty("password")
        map(roleId).toProperty("roleId")
    }

fun UserMapper.insertMultiple(records: Collection<UserRecord>) =
    insertMultiple(this::insertMultiple, records, User) {
        map(userId).toProperty("userId")
        map(name).toProperty("name")
        map(email).toProperty("email")
        map(password).toProperty("password")
        map(roleId).toProperty("roleId")
    }

fun UserMapper.insertMultiple(vararg records: UserRecord) =
    insertMultiple(records.toList())

fun UserMapper.insertSelective(record: UserRecord) =
    insert(this::insert, record, User) {
        map(userId).toPropertyWhenPresent("userId", record::userId)
        map(name).toPropertyWhenPresent("name", record::name)
        map(email).toPropertyWhenPresent("email", record::email)
        map(password).toPropertyWhenPresent("password", record::password)
        map(roleId).toPropertyWhenPresent("roleId", record::roleId)
    }

private val columnList = listOf(userId, name, email, password, roleId)

fun UserMapper.selectOne(completer: SelectCompleter) =
    selectOne(this::selectOne, columnList, User, completer)

fun UserMapper.select(completer: SelectCompleter) =
    selectList(this::selectMany, columnList, User, completer)

fun UserMapper.selectDistinct(completer: SelectCompleter) =
    selectDistinct(this::selectMany, columnList, User, completer)

fun UserMapper.selectByPrimaryKey(userId_: Long) =
    selectOne {
        where(userId, isEqualTo(userId_))
    }

fun UserMapper.update(completer: UpdateCompleter) =
    update(this::update, User, completer)

fun KotlinUpdateBuilder.updateAllColumns(record: UserRecord) =
    apply {
        set(userId).equalTo(record::userId)
        set(name).equalTo(record::name)
        set(email).equalTo(record::email)
        set(password).equalTo(record::password)
        set(roleId).equalTo(record::roleId)
    }

fun KotlinUpdateBuilder.updateSelectiveColumns(record: UserRecord) =
    apply {
        set(userId).equalToWhenPresent(record::userId)
        set(name).equalToWhenPresent(record::name)
        set(email).equalToWhenPresent(record::email)
        set(password).equalToWhenPresent(record::password)
        set(roleId).equalToWhenPresent(record::roleId)
    }

fun UserMapper.updateByPrimaryKey(record: UserRecord) =
    update {
        set(name).equalTo(record::name)
        set(email).equalTo(record::email)
        set(password).equalTo(record::password)
        set(roleId).equalTo(record::roleId)
        where(userId, isEqualTo(record::userId))
    }

fun UserMapper.updateByPrimaryKeySelective(record: UserRecord) =
    update {
        set(name).equalToWhenPresent(record::name)
        set(email).equalToWhenPresent(record::email)
        set(password).equalToWhenPresent(record::password)
        set(roleId).equalToWhenPresent(record::roleId)
        where(userId, isEqualTo(record::userId))
    }