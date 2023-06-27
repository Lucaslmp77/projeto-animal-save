package br.com.projetoanimalsave.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

@Entity
@Table(name = "tb_associados", schema = "projeto-animal-save")
public class Associate extends AbstractEntity {

    @Getter
    @Setter
    @Column(name = "nome", length = 30, nullable = false)
    private String firstName;

    @Getter
    @Setter
    @Column(name = "sobrenome", length = 30, nullable = false)
    private String lastName;

    @Getter
    @Setter
    @Column(name = "contato", length = 30, nullable = false)
    private String contact;

    @Getter
    @Setter
    @CPF
    @Column(name = "cpf", length = 50, nullable = false, unique = true)
    private String cpf;


    @OneToOne
    @Getter
    @Setter
    @JoinColumn(name = "address_id", nullable = false)
    private Address address;

    @OneToOne
    @Getter
    @Setter
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
}
