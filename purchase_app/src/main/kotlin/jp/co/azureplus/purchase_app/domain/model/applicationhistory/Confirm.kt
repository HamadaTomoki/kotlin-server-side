/*
 * Auto-generated file. Created by MyBatis Generator
 */
package jp.co.azureplus.purchase_app.domain.model.applicationhistory

import jp.co.azureplus.purchase_app.domain.enumtype.ConfirmStatus
import java.time.LocalDateTime

data class Confirm(
    val confirmDate: LocalDateTime?,
    val confirmStatus: ConfirmStatus?,
    val reason: String?,
)
