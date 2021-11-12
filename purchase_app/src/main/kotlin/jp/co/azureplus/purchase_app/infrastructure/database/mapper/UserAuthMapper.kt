package jp.co.azureplus.purchase_app.infrastructure.database.mapper

import jp.co.azureplus.purchase_app.domain.model.userauth.UserAuth
import jp.co.azureplus.purchase_app.infrastructure.database.record.UserAuthRecord
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Result
import org.apache.ibatis.annotations.Results
import org.apache.ibatis.annotations.SelectProvider
import org.apache.ibatis.type.EnumTypeHandler
import org.apache.ibatis.type.JdbcType
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider
import org.mybatis.dynamic.sql.util.SqlProviderAdapter


@Mapper
interface UserAuthMapper {
    @SelectProvider(type = SqlProviderAdapter::class, method = "select")
    @Results(
        value = [
            Result(column = "email", property = "email", jdbcType = JdbcType.VARCHAR),
            Result(column = "password", property = "password", jdbcType = JdbcType.VARCHAR),
            Result(column = "role_type", property = "roleType", typeHandler = EnumTypeHandler::class, jdbcType = JdbcType.CHAR)
        ]
    )
    fun selectOne(selectStatement: SelectStatementProvider): UserAuthRecord
}
