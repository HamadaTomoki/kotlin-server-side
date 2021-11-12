package jp.co.azureplus.purchase_app.infrastructure.database.mapper

import jp.co.azureplus.purchase_app.infrastructure.database.mapper.generated.ApplicationDynamicSqlSupport.Application
import jp.co.azureplus.purchase_app.infrastructure.database.mapper.generated.ConfirmDynamicSqlSupport.Confirm
import jp.co.azureplus.purchase_app.infrastructure.database.record.ApplicationHistoryRecord
import org.mybatis.dynamic.sql.util.kotlin.elements.equalTo
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.select

private val columnList =
    listOf(
        Application.appDate,
        Application.reason,
        Confirm.confirmDate,
        Confirm.confirmStatus,
        Confirm.reason
    )

fun ApplicationHistoryMapper.select(): List<ApplicationHistoryRecord> =
    select(columnList) {
        from(Application, "a")
        join(Confirm, "c") {
            on(Application.confirmId, equalTo(Confirm.confirmId))
        }
    }.run(this::selectMany)
