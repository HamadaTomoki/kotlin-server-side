package jp.co.azureplus.purchase_app.presentation.form

import jp.co.azureplus.purchase_app.domain.enumtype.ConfirmStatus
import jp.co.azureplus.purchase_app.domain.model.applicationhistory.ApplicationHistory
import java.time.LocalDateTime


// 申請履歴のリスト
data class GetApplicationHistoryResponse(val applicationHistory: List<ApplicationInfo>)
data class ApplicationInfo(
    val appDate: LocalDateTime?,
    val appReason: String?,
    val confirmDate: LocalDateTime?,
    val confirmStatus: ConfirmStatus?,
    val confirmReason: String?,
) {
    constructor(model: ApplicationHistory) : this(
        model.application.appDate,
        model.application.reason,
        model.confirm.confirmDate,
        model.confirm.confirmStatus,
        model.confirm.reason,
    )
}

// メール
