package jp.co.azureplus.purchase_app.presentation.controller

import jp.co.azureplus.purchase_app.application.service.ApplicationService
import jp.co.azureplus.purchase_app.presentation.form.ApplicationInfo
import jp.co.azureplus.purchase_app.presentation.form.GetApplicationHistoryResponse
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("application")
class ApplicationController(
    private val applicationService: ApplicationService
) {
    @GetMapping("history")
    fun showHistory(): GetApplicationHistoryResponse {
        val applicationList = applicationService.getApplicationHistory().map {
            ApplicationInfo(it)
        }
        return GetApplicationHistoryResponse(applicationList)
    }
    /*
     curl -i -b /Users/hamadatomoki/IdeaProjects/purchase_app/cookie/cookie.txt \
     http://localhost:8080/application/history

     curl http://localhost:8080/application/history \
     -w '\nStatuscode: %{http_code}\n'

     */

    @PostMapping("email")
    fun sendEmail() {
        applicationService.sendEmail("hello", "kotlin", "hamada.tomoki03@gmail.com")
    }
    // curl -X POST http://localhost:8080/application/email
}
