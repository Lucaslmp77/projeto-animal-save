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
    @Column(name = "nome_fantasia", length = 50, nullable = false)
    private String fantasyName;

    @Getter
    @Column(name = "nome_empresarial", length = 50, nullable = false)
    private String businessName;

    @Getter
    @Setter
    @CNPJ
    @Column(name = "cnpj", length = 50, nullable = false, unique = true)
    private String cnpj;

    @Getter
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

    public void setFantasyName(String fantasyName) {
        if(fantasyName == null) {
            throw new RuntimeException("O nome fantasia do fornecedor inserido é nulo");
        } else if (fantasyName.isEmpty()) {
            throw new RuntimeException("O nome fantasia do fornecedor inserido está vazio");
        } else if (fantasyName.trim().length() < 3) {
            throw new RuntimeException("O nome fantasia do fornecedor inserido é muito curto");
        } else if (fantasyName.trim().length() > 40) {
            throw new RuntimeException("O nome fantasia do fornecedor inserido ultrapassa o limite máximo");
        } else if (fantasyName.matches("[0-9]+")) {
            throw new RuntimeException("O nome fantasia do fornecedor inserido é composto por números");
        }
        else {
            this.fantasyName = fantasyName;
        }
    }

    public void setBusinessName(String businessName) {
        if(businessName == null) {
            throw new RuntimeException("O nome empresarial do fornecedor inserido é nulo");
        } else if (businessName.isEmpty()) {
            throw new RuntimeException("O nome empresarial do fornecedor inserido está vazio");
        } else if (businessName.trim().length() < 3) {
            throw new RuntimeException("O nome empresarial do fornecedor inserido é muito curto");
        } else if (businessName.trim().length() > 80) {
            throw new RuntimeException("O nome empresarial do fornecedor inserido ultrapassa o limite máximo");
        } else if (businessName.matches("[0-9]+")) {
            throw new RuntimeException("O nome empresarial do fornecedor inserido é composto por números");
        }
        else {
            this.businessName = businessName;
        }
    }

    public void setContact(String contact) {
        if(contact == null) {
            throw new RuntimeException("O contato inserido é nulo");
        } else if (contact.isEmpty()) {
            throw new RuntimeException("O contato inserido está vazio");
        } else if (contact.trim().length() < 5) {
            throw new RuntimeException("O contato inserido é muito curto");
        } else if (contact.trim().length() > 25) {
            throw new RuntimeException("O contato do associado inserido ultrapassa o limite máximo");
        } else {
            this.contact = contact;
        }
    }
}
