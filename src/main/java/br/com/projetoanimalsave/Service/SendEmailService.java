package br.com.projetoanimalsave.Service;

import br.com.projetoanimalsave.Entity.SendEmail;
import br.com.projetoanimalsave.Repository.SendEmailRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class SendEmailService {
    @Autowired
    SendEmailRepository sendEmailRepository;

    @Autowired
    private JavaMailSender emailSender;

    @Transactional
    public SendEmail sendEmail(SendEmail sendEmail) {
        sendEmail.setSendDateEmail(LocalDateTime.now());
        try{
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(sendEmail.getEmailFrom());
            message.setTo(sendEmail.getEmailTo());
            message.setSubject(sendEmail.getSubject());
            message.setText(sendEmail.getText());
            emailSender.send(message);
        } catch (MailException e){
            throw new RuntimeException(e.getMessage());
        } finally {
            return sendEmailRepository.save(sendEmail);
        }
    }
}
