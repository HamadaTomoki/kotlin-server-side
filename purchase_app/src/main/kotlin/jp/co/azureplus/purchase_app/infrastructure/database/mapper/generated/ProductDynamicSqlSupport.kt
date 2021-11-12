/*
 * Auto-generated file. Created by MyBatis Generator
 */
package jp.co.azureplus.purchase_app.infrastructure.database.mapper.generated

import java.sql.JDBCType
import org.mybatis.dynamic.sql.SqlTable

object ProductDynamicSqlSupport {
    object Product : SqlTable("product") {
        val productId = column<Long>("product_id", JDBCType.BIGINT)

        val name = column<String>("name", JDBCType.VARCHAR)

        val price = column<Long>("price", JDBCType.BIGINT)

        val quantity = column<Long>("quantity", JDBCType.BIGINT)

        val url = column<String>("url", JDBCType.VARCHAR)

        val categoryId = column<Long>("category_id", JDBCType.BIGINT)

        val providerId = column<Long>("provider_id", JDBCType.BIGINT)
    }
}