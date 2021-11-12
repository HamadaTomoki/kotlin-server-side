package jp.co.azureplus.purchase_app.application.service

import jp.co.azureplus.purchase_app.domain.model.applicationhistory.ApplicationHistory
import jp.co.azureplus.purchase_app.domain.repository.ApplicationRepository
import org.springframework.mail.SimpleMailMessage
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.stereotype.Service

@Service
class ApplicationService(
    private val applicationRepository: ApplicationRepository,
    private val emailSender: JavaMailSender
) {
    fun getApplicationHistory(): List<ApplicationHistory> {
        return applicationRepository.findApplicationHistory()
    }

    fun sendEmail(
        subject: String,
        text: String,
        targetEmail: String
    ) {
        val message = SimpleMailMessage()
        message.apply {
            setSubject(subject)
            setText(text)
            setTo(targetEmail)
        }

        emailSender.send(message)
    }
}
