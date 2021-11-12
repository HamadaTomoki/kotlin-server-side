package jp.co.azureplus.purchase_app.infrastructure.database.mapper

import jp.co.azureplus.purchase_app.infrastructure.database.mapper.generated.RoleDynamicSqlSupport.Role
import jp.co.azureplus.purchase_app.infrastructure.database.mapper.generated.UserDynamicSqlSupport.User
import jp.co.azureplus.purchase_app.infrastructure.database.record.UserAuthRecord
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.select
import org.mybatis.dynamic.sql.util.kotlin.elements.equalTo
import org.mybatis.dynamic.sql.util.kotlin.elements.isEqualTo

private val columnList =
    listOf(
        User.email,
        User.password,
        Role.roleType
    )

fun UserAuthMapper.select(email: String): UserAuthRecord =
    select(columnList) {
        from(User, "u")
        where(User.email, isEqualTo(email))
        join(Role, "r") {
            on(User.roleId, equalTo(Role.roleId))
        }
    }.run(this::selectOne)
