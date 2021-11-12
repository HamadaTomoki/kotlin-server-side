package jp.co.azureplus.purchase_app.domain.repository

import jp.co.azureplus.purchase_app.domain.model.userauth.UserAuth

interface UserRepository {
    fun findByEmail(email: String): UserAuth?
}
