package jp.co.azureplus.purchase_app.application.service.security

import jp.co.azureplus.purchase_app.application.service.PurchaseAppAuthenticationService
import jp.co.azureplus.purchase_app.domain.enumtype.RoleType
import jp.co.azureplus.purchase_app.domain.model.userauth.UserAuth
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.AuthorityUtils
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService

class UserInfoService(
    private val authenticationService: PurchaseAppAuthenticationService
) : UserDetailsService {
    override fun loadUserByUsername(username: String): UserDetails? {
        val user = authenticationService.findByUser(username)
        return user?.let { UserInfo(user) }
    }
}

data class UserInfo(val email: String?, val pass: String?, val role: RoleType?) :
    UserDetails {

    constructor(userAuth: UserAuth)
            : this(
        userAuth.user.email,
        userAuth.user.password,
        userAuth.role.roleType,
    )

    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
        return AuthorityUtils.createAuthorityList(this.role.toString())
    }

    override fun isEnabled(): Boolean {
        return true
    }

    override fun getUsername(): String? {
        return this.email
    }

    override fun isCredentialsNonExpired(): Boolean {
        return true
    }

    override fun getPassword(): String? {
        return this.pass
    }

    override fun isAccountNonExpired(): Boolean {
        return true
    }

    override fun isAccountNonLocked(): Boolean {
        return true
    }
}
