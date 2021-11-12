package jp.co.azureplus.purchase_app.application.service

import jp.co.azureplus.purchase_app.domain.model.userauth.UserAuth
import jp.co.azureplus.purchase_app.domain.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class PurchaseAppAuthenticationService(
    private val userRepository: UserRepository
) {
    fun findByUser(email: String): UserAuth? {
        return userRepository.findByEmail(email)
    }
}
