package br.com.projetoanimalsave.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CNPJ;

import java.util.Set;

@Entity
@Table(name = "tb_fornecedores", schema = "projeto-animal-save")
public class Provider extends AbstractEntity {

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
    @CNPJ
    @Length(min = 3, max = 25, message = "O CNPJ deve ter no mínimo {min} caracteres e no maximo {max} caracteres")
    @Column(name = "cnpj", length = 25, nullable = false)
    private String cnpj;

    @Getter
    @Setter
    @Column(name = "contato", length = 14, nullable = false)
    private String contact;

    @OneToOne
    @Getter
    @Setter
    @JoinColumn(name = "address_id", nullable = false)
    private Address address;

    @OneToMany(mappedBy = "provider")
    private Set<Task> tasks;

    @Getter
    @Setter
    @Column(name = "aprovação", length = 15, nullable = false)
    @Enumerated(EnumType.STRING)
    private Aprove aprove;

    @OneToOne
    @Getter
    @Setter
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
}
