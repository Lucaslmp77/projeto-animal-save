package br.com.projetoanimalsave.Dto;

import jakarta.validation.constraints.Email;
import lombok.Data;

@Data
public class SendEmailDto {
    private String ownerRef;
    @Email
    private String emailFrom;
    @Email
    private String emailTo;
    private String subject;
    private String text;
}
