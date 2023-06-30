package br.com.projetoanimalsave.Entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

public class SendEmailTest {

    @Test
    public void testGetEmailId() {
        Long emailId = 1L;
        SendEmail sendEmail = new SendEmail();
        sendEmail.setEmailId(emailId);

        Assertions.assertEquals(emailId, sendEmail.getEmailId());
    }

    @Test
    public void testGetOwnerRef() {
        String ownerRef = "Animal Save";
        SendEmail sendEmail = new SendEmail();
        sendEmail.setOwnerRef(ownerRef);

        Assertions.assertEquals(ownerRef, sendEmail.getOwnerRef());
    }

    @Test
    public void testGetEmailFrom() {
        String emailFrom = "animalsavepi@gmail.com";
        SendEmail sendEmail = new SendEmail();
        sendEmail.setEmailFrom(emailFrom);

        Assertions.assertEquals(emailFrom, sendEmail.getEmailFrom());
    }

    @Test
    public void testGetEmailTo() {
        String emailTo = "lucas.lmp77@gmail.com";
        SendEmail sendEmail = new SendEmail();
        sendEmail.setEmailTo(emailTo);

        Assertions.assertEquals(emailTo, sendEmail.getEmailTo());
    }

    @Test
    public void testGetSubject() {
        String subject = "Credenciais de acesso";
        SendEmail sendEmail = new SendEmail();
        sendEmail.setSubject(subject);

        Assertions.assertEquals(subject, sendEmail.getSubject());
    }

    @Test
    public void testGetText() {
        String text = "Login e senha do lucas";
        SendEmail sendEmail = new SendEmail();
        sendEmail.setText(text);

        Assertions.assertEquals(text, sendEmail.getText());
    }

    @Test
    public void testGetSendDateEmail() {
        LocalDateTime sendDateEmail = LocalDateTime.now();
        SendEmail sendEmail = new SendEmail();
        sendEmail.setSendDateEmail(sendDateEmail);

        Assertions.assertEquals(sendDateEmail, sendEmail.getSendDateEmail());
    }
}
