package jp.co.azureplus.purchase_app.infrastructure.database.record

import jp.co.azureplus.purchase_app.domain.enumtype.ConfirmStatus
import java.time.LocalDateTime

data class ApplicationHistoryRecord(
    var appDate: LocalDateTime? = null,
    var appReason: String? = null,
    var confirmDate: LocalDateTime? = null,
    var confirmStatus: ConfirmStatus? = null,
    var confirmReason: String? = null,
)
