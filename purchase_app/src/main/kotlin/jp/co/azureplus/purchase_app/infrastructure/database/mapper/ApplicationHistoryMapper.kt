package jp.co.azureplus.purchase_app.infrastructure.database.mapper

import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Result
import org.apache.ibatis.annotations.Results
import org.apache.ibatis.annotations.SelectProvider
import org.apache.ibatis.type.JdbcType
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider
import org.mybatis.dynamic.sql.util.SqlProviderAdapter

import jp.co.azureplus.purchase_app.infrastructure.database.record.ApplicationHistoryRecord
import org.apache.ibatis.type.EnumTypeHandler

@Mapper
interface ApplicationHistoryMapper {
    @SelectProvider(type = SqlProviderAdapter::class, method = "select")
    @Results(
        value = [
            Result(column="app_date", property="appDate", jdbcType=JdbcType.TIMESTAMP),
            Result(column = "reason", property = "appReason", jdbcType = JdbcType.VARCHAR),
            Result(column = "confirm_date", property = "confirmDate", jdbcType = JdbcType.TIMESTAMP),
            Result(column="confirm_status", property="confirmStatus", typeHandler= EnumTypeHandler::class, jdbcType=JdbcType.CHAR),
            Result(column = "reason", property = "confirmReason", jdbcType = JdbcType.VARCHAR)
        ]
    )
    fun selectMany(selectStatement: SelectStatementProvider): List<ApplicationHistoryRecord>
}
