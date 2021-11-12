package jp.co.azureplus.purchase_app.infrastructure.database.repository

import jp.co.azureplus.purchase_app.domain.model.applicationhistory.Application
import jp.co.azureplus.purchase_app.domain.model.applicationhistory.ApplicationHistory
import jp.co.azureplus.purchase_app.domain.model.applicationhistory.Confirm
import jp.co.azureplus.purchase_app.domain.repository.ApplicationRepository
import jp.co.azureplus.purchase_app.infrastructure.database.mapper.ApplicationHistoryMapper
import jp.co.azureplus.purchase_app.infrastructure.database.mapper.select
import jp.co.azureplus.purchase_app.infrastructure.database.record.ApplicationHistoryRecord
import org.springframework.stereotype.Repository

@Repository("ApplicationRepositoryImpl")
class ApplicationRepositoryImpl(
    private val applicationHistoryMapper: ApplicationHistoryMapper
) : ApplicationRepository {
    override fun findApplicationHistory(): List<ApplicationHistory> {
        return applicationHistoryMapper.select().map { toModel(it) }
    }

    private fun toModel(record: ApplicationHistoryRecord): ApplicationHistory =
        ApplicationHistory(
            Application(
                record.appDate!!,
                record.appReason!!,
            ),
            Confirm(
                record.confirmDate,
                record.confirmStatus!!,
                record.confirmReason
            )
        )
}
