package br.com.projetoanimalsave.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "tb_administradores", schema = "projeto-animal-save")
public class Admin extends AbstractEntity {
    @Getter
    @Setter
    @Length(min = 3, max = 25, message = "O usuário deve ter no mínimo {min} caracteres e no maximo {max} caracteres")
    @Column(name = "username", length = 25, nullable = false)
    private String username;

    @Getter
    @Setter
    @Length(min = 3, max = 25, message = "A senha deve ter no mínimo {min} caracteres e no maximo {max} caracteres")
    @Column(name = "senha", length = 25, nullable = false)
    private String password;

    @Getter @Setter
    @Column(name = "cargo", length = 15, nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;
}
