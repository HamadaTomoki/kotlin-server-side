/*
 * Auto-generated file. Created by MyBatis Generator
 */
package jp.co.azureplus.purchase_app.infrastructure.database.record.generated

import java.time.LocalDateTime
import jp.co.azureplus.purchase_app.domain.enumtype.ConfirmStatus

data class ConfirmRecord(
    var confirmId: Long? = null,
    var confirmDate: LocalDateTime? = null,
    var confirmStatus: ConfirmStatus? = null,
    var reason: String? = null
)