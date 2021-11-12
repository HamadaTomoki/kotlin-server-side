/*
 * Auto-generated file. Created by MyBatis Generator
 */
package jp.co.azureplus.purchase_app.infrastructure.database.mapper.generated

import java.sql.JDBCType
import org.mybatis.dynamic.sql.SqlTable

object UserDynamicSqlSupport {
    object User : SqlTable("user") {
        val userId = column<Long>("user_id", JDBCType.BIGINT)

        val name = column<String>("name", JDBCType.VARCHAR)

        val email = column<String>("email", JDBCType.VARCHAR)

        val password = column<String>("password", JDBCType.VARCHAR)

        val roleId = column<Long>("role_id", JDBCType.BIGINT)
    }
}