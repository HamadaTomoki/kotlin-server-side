package jp.co.azureplus.purchase_app.presentation.config

import jp.co.azureplus.purchase_app.application.service.PurchaseAppAuthenticationService
import jp.co.azureplus.purchase_app.application.service.security.UserInfoService
import jp.co.azureplus.purchase_app.domain.enumtype.RoleType
import jp.co.azureplus.purchase_app.presentation.handler.PurchaseAppAccessDeniedHandler
import jp.co.azureplus.purchase_app.presentation.handler.PurchaseAppAuthenticationEntryPoint
import jp.co.azureplus.purchase_app.presentation.handler.PurchaseAppAuthenticationFailureHandler
import jp.co.azureplus.purchase_app.presentation.handler.PurchaseAppAuthenticationSuccessHandler
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.CorsConfigurationSource
import org.springframework.web.cors.UrlBasedCorsConfigurationSource

/*
curl -i -c /Users/hamadatomoki/IdeaProjects/purchase_app/cookie/cookie.txt \
-H "Content-Type:application/x-www-form-urlencoded" \
-X POST -d 'email=hamada.tomoki01@gmail.com' -d 'pass=kotlin' http://localhost:8080/login \
-w '\nStatuscode: %{http_code}\n'
*/

@EnableWebSecurity
class SecurityConfig(private val authenticationService: PurchaseAppAuthenticationService) : WebSecurityConfigurerAdapter() {
    /** 認証, 認可に関する設定 */
    override fun configure(http: HttpSecurity) {
        // mvcMatcherで対象のAPIのパスを指定し、後ろにチェインしている関数で権限を設定している
        http.authorizeRequests()
            /** アクセス権の設定 */
            // /loginでログインAPIに対して未認証ユーザーを含むすべてのアクセスを許可
            .mvcMatchers("/login").permitAll()
            // /adminから始まるAPIに対して管理者権限のユーザーのみアクセスを許可
            .mvcMatchers("/admin/**").hasAuthority(RoleType.ADMIN.toString())
            // 上記以外のAPIは認証済みユーザーのみアクセスを許可する
            .anyRequest().authenticated()

            /** CSRFに関する設定 */
            .and()
            .csrf().disable()

            /** 認証方法の設定 */
            // フォームログイン(ユーザー名, パスワードでのログイン)を有効化
            .formLogin()
            // ログインAPIのパスを/loginに設定
            .loginProcessingUrl("/login")
            // ログインAPIにわたすユーザー名のパラメータ名を email に設定
            .usernameParameter("email")
            // ログインAPIにわたすパスワードのパラメータ名を pass に設定
            .passwordParameter("pass")

            /** 認証, 認可時の各種ハンドラーの設定 */
            // 認証成功時に実行するハンドラーを設定
            .successHandler(PurchaseAppAuthenticationSuccessHandler())
            // 認証失敗時に実行するハンドラーを設定
            .failureHandler(PurchaseAppAuthenticationFailureHandler())
            .and()
            .exceptionHandling()
            // 未認証時のハンドラーを設定
            .authenticationEntryPoint(PurchaseAppAuthenticationEntryPoint())
            // 認可失敗時のハンドラーを設定
            .accessDeniedHandler(PurchaseAppAccessDeniedHandler())

            /** CORS(Cross-Origin Resource Sharing)に関する設定 */
            .and()
            .cors()
            .configurationSource(corsConfigurationSource())
    }

    override fun configure(auth: AuthenticationManagerBuilder) {
        auth.userDetailsService(UserInfoService(authenticationService))
            .passwordEncoder(BCryptPasswordEncoder())
    }


    /**
     * CORSに関する各種の許可設定
     */
    private fun corsConfigurationSource(): CorsConfigurationSource {
        val corsConfiguration = CorsConfiguration()
        corsConfiguration.apply {
            // メソッドとヘッダを全て許可
            addAllowedMethod(CorsConfiguration.ALL)
            addAllowedHeader(CorsConfiguration.ALL)
            // アクセス元のドメインを許可
            addAllowedOrigin("http://localhost:8081")
            allowCredentials = true
        }

        val corsConfigurationSource = UrlBasedCorsConfigurationSource()
        corsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration)

        return corsConfigurationSource
    }
}
