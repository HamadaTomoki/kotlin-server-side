package jp.co.azureplus.purchase_app.infrastructure.database.repository

import jp.co.azureplus.purchase_app.domain.model.userauth.Role
import jp.co.azureplus.purchase_app.domain.model.userauth.User
import jp.co.azureplus.purchase_app.domain.model.userauth.UserAuth
import jp.co.azureplus.purchase_app.domain.repository.UserRepository
import jp.co.azureplus.purchase_app.infrastructure.database.mapper.UserAuthMapper
import jp.co.azureplus.purchase_app.infrastructure.database.mapper.select
import jp.co.azureplus.purchase_app.infrastructure.database.record.UserAuthRecord
import org.springframework.stereotype.Repository

@Repository("UserRepositoryImpl")
class UserRepositoryImpl(
    private val userAuthMapper: UserAuthMapper
) : UserRepository {
    override fun findByEmail(email: String): UserAuth {
        return toModel(userAuthMapper.select(email))
    }

    private fun toModel(record: UserAuthRecord): UserAuth =
        UserAuth(
            User(
                record.email!!,
                record.password!!,
            ),
            Role(
                record.roleType!!
            )
        )
}
