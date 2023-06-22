package br.com.projetoanimalsave.Controller;

import br.com.projetoanimalsave.Dto.SendEmailDto;
import br.com.projetoanimalsave.Entity.SendEmail;
import br.com.projetoanimalsave.Service.SendEmailService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/email")
public class SendEmailController {

    @Autowired
    SendEmailService sendEmailService;

    @PostMapping("/sending-email")
    public ResponseEntity<SendEmail> sendingEmail(@RequestBody @Valid SendEmailDto sendEmailDto) {
        SendEmail sendEmail = new SendEmail();
        BeanUtils.copyProperties(sendEmailDto, sendEmail);
        sendEmailService.sendEmail(sendEmail);
        return new ResponseEntity<>(sendEmail, HttpStatus.CREATED);
    }
}