package br.com.projetoanimalsave.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

@Entity
@Table(name = "tb_associados", schema = "projeto-animal-save")
public class Associate extends AbstractEntity {

    @Getter
    @Setter
    @Length(min = 3, max = 25, message = "O nome deve ter no mínimo {min} caracteres e no maximo {max} caracteres")
    @Column(name = "nome", length = 25, nullable = false)
    private String firstName;

    @Getter
    @Setter
    @Length(min = 3, max = 25, message = "O sobrenome deve ter no mínimo {min} caracteres e no maximo {max} caracteres")
    @Column(name = "sobrenome", length = 25, nullable = false)
    private String lastName;

    @Getter
    @Setter
    @Column(name = "contato", length = 14, nullable = false)
    private String contact;

    @Getter
    @Setter
    @CPF
    @Column(name = "cpf", length = 16, nullable = false)
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

    @Getter
    @Setter
    @Column(name = "aprovado", length = 25, nullable = false)
    private Boolean approved;

    @Getter
    @Setter
    @Column(name = "pendente", length = 25, nullable = false)
    private Boolean pending;

    @Getter
    @Setter
    @Column(name = "rejeitado", length = 25, nullable = false)
    private Boolean rejected;
}
