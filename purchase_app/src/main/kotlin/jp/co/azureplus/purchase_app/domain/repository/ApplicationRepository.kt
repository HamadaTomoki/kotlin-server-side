package jp.co.azureplus.purchase_app.domain.repository

import jp.co.azureplus.purchase_app.domain.model.applicationhistory.ApplicationHistory

interface ApplicationRepository {
    fun findApplicationHistory():List<ApplicationHistory>
}
