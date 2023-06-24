package br.com.projetoanimalsave.Dto;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

public class NewPassword {
    @Getter
    @Setter
    @Column(name = "nova-senha", length = 90, nullable = false)
    private String newPassword;
}
