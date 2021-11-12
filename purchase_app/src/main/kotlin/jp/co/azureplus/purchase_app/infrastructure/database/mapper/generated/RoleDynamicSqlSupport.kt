/*
 * Auto-generated file. Created by MyBatis Generator
 */
package jp.co.azureplus.purchase_app.infrastructure.database.mapper.generated

import java.sql.JDBCType
import jp.co.azureplus.purchase_app.domain.enumtype.RoleType
import org.mybatis.dynamic.sql.SqlTable

object RoleDynamicSqlSupport {
    object Role : SqlTable("role") {
        val roleId = column<Long>("role_id", JDBCType.BIGINT)

        val roleType = column<RoleType>("role_type", JDBCType.CHAR, "org.apache.ibatis.type.EnumTypeHandler")
    }
}