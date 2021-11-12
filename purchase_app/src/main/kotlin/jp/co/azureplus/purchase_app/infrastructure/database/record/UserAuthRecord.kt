package jp.co.azureplus.purchase_app.infrastructure.database.record

import jp.co.azureplus.purchase_app.domain.enumtype.RoleType

data class UserAuthRecord(
    var email: String? = null,
    var password: String? = null,
    var roleType: RoleType? = null
)
