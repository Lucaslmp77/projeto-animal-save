package br.com.projetoanimalsave.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_administradores", schema = "projeto-animal-save")
public class Admin extends AbstractEntity {

    @Getter
    @Setter
    @Column(name = "nome", length = 25, nullable = false)
    private String name;

    @OneToOne
    @Getter
    @Setter
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

}
