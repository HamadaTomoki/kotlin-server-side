/*
 * Auto-generated file. Created by MyBatis Generator
 */
package jp.co.azureplus.purchase_app.infrastructure.database.mapper.generated

import java.sql.JDBCType
import java.time.LocalDateTime
import org.mybatis.dynamic.sql.SqlTable

object ApplicationDynamicSqlSupport {
    object Application : SqlTable("application") {
        val userId = column<Long>("user_id", JDBCType.BIGINT)

        val confirmId = column<Long>("confirm_id", JDBCType.BIGINT)

        val reason = column<String>("reason", JDBCType.VARCHAR)

        val appDate = column<LocalDateTime>("app_date", JDBCType.TIMESTAMP)

        val productId = column<Long>("product_id", JDBCType.BIGINT)
    }
}