/*
 * Auto-generated file. Created by MyBatis Generator
 */
package jp.co.azureplus.purchase_app.infrastructure.database.mapper.generated

import java.sql.JDBCType
import org.mybatis.dynamic.sql.SqlTable

object ProviderDynamicSqlSupport {
    object Provider : SqlTable("provider") {
        val providerId = column<Long>("provider_id", JDBCType.BIGINT)

        val name = column<String>("name", JDBCType.VARCHAR)
    }
}