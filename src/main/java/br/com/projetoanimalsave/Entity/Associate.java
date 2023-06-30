package br.com.projetoanimalsave.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

@Entity
@Table(name = "tb_associados", schema = "projeto-animal-save")
public class Associate extends AbstractEntity {

    @Getter
    @Column(name = "nome", length = 30, nullable = false)
    private String firstName;

    @Getter
    @Column(name = "sobrenome", length = 30, nullable = false)
    private String lastName;

    @Getter
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

    public void setFirstName(String firstName) {
        if(firstName == null) {
            throw new RuntimeException("O nome do associado inserido é nulo");
        } else if (firstName.isEmpty()) {
            throw new RuntimeException("O nome do associado inserido está vazio");
        } else if (firstName.trim().length() < 3) {
            throw new RuntimeException("O nome do associado inserido é muito curto");
        } else if (firstName.trim().length() > 30) {
            throw new RuntimeException("O nome do associado inserido ultrapassa o limite máximo");
        } else if (firstName.matches("[0-9]+")) {
            throw new RuntimeException("O nome do associado inserido é composto por números");
        }
        else {
            this.firstName = firstName;
        }
    }

    public void setLastName(String lastName) {
        if(lastName == null) {
            throw new RuntimeException("O sobrenome do associado inserido é nulo");
        } else if (lastName.isEmpty()) {
            throw new RuntimeException("O sobrenome do associado inserido está vazio");
        } else if (lastName.trim().length() < 2) {
            throw new RuntimeException("O sobrenome do associado inserido é muito curto");
        } else if (lastName.trim().length() > 50) {
            throw new RuntimeException("O sobrenome do associado inserido ultrapassa o limite máximo");
        } else if (lastName.matches("[0-9]+")) {
            throw new RuntimeException("O sobrenome do associado inserido é composto por números");
        }
        else {
            this.lastName = lastName;
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
