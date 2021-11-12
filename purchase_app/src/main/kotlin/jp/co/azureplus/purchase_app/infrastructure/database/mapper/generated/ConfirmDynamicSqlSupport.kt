/*
 * Auto-generated file. Created by MyBatis Generator
 */
package jp.co.azureplus.purchase_app.infrastructure.database.mapper.generated

import java.sql.JDBCType
import java.time.LocalDateTime
import jp.co.azureplus.purchase_app.domain.enumtype.ConfirmStatus
import org.mybatis.dynamic.sql.SqlTable

object ConfirmDynamicSqlSupport {
    object Confirm : SqlTable("confirm") {
        val confirmId = column<Long>("confirm_id", JDBCType.BIGINT)

        val confirmDate = column<LocalDateTime>("confirm_date", JDBCType.TIMESTAMP)

        val confirmStatus = column<ConfirmStatus>("confirm_status", JDBCType.CHAR, "org.apache.ibatis.type.EnumTypeHandler")

        val reason = column<String>("reason", JDBCType.VARCHAR)
    }
}