package br.com.projetoanimalsave.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CNPJ;

import java.util.Set;

@Entity
@Table(name = "tb_fornecedores", schema = "projeto-animal-save")
public class Provider extends AbstractEntity {

    @Getter
    @Setter
    @Column(name = "nome_fantasia", length = 50, nullable = false)
    private String fantasyName;

    @Getter
    @Setter
    @Column(name = "nome_empresarial", length = 50, nullable = false)
    private String businessName;

    @Getter
    @Setter
    @CNPJ
    @Column(name = "cnpj", length = 50, nullable = false, unique = true)
    private String cnpj;

    @Getter
    @Setter
    @Column(name = "contato", length = 50, nullable = false)
    private String contact;

    @OneToOne
    @Getter
    @Setter
    @JoinColumn(name = "address_id", nullable = false)
    private Address address;

    @OneToMany(mappedBy = "provider")
    private Set<Task> tasks;

    @OneToOne
    @Getter
    @Setter
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
}
