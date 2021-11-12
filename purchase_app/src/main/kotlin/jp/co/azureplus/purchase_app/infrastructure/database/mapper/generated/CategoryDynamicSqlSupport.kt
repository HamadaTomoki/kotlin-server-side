/*
 * Auto-generated file. Created by MyBatis Generator
 */
package jp.co.azureplus.purchase_app.infrastructure.database.mapper.generated

import java.sql.JDBCType
import org.mybatis.dynamic.sql.SqlTable

object CategoryDynamicSqlSupport {
    object Category : SqlTable("category") {
        val categoryId = column<Long>("category_id", JDBCType.BIGINT)

        val name = column<String>("name", JDBCType.VARCHAR)
    }
}