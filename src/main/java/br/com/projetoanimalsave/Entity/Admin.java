package br.com.projetoanimalsave.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_administradores", schema = "projeto-animal-save")
public class Admin extends AbstractEntity {

    @Getter
    @Column(name = "nome", length = 25, nullable = false)
    private String name;

    public void setName(String name) {
        if(name == null) {
            throw new RuntimeException("O nome do administrador inserido é nulo");
        } else if (name.isEmpty()) {
            throw new RuntimeException("O nome do administrador inserido está vazio");
        } else if (name.trim().length() < 3) {
            throw new RuntimeException("O nome do administrador inserido é muito curto");
        } else if (name.trim().length() > 25) {
            throw new RuntimeException("O nome do administrador inserido ultrapassa o limite máximo");
        } else if (name.matches("[0-9]+")) {
            throw new RuntimeException("O nome do administrador inserido é composto por números");
        }
        else {
            this.name = name;
        }
    }

    @OneToOne
    @Getter
    @Setter
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

}
