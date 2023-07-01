package br.com.projetoanimalsave.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import java.util.List;

@Entity
@Table(name = "tb_cuidadores", schema = "projeto-animal-save")
public class Caregiver extends AbstractEntity{

    @Getter
    @Column(name = "nome", length = 50, nullable = false)
    private String firstName;

    @Getter
    @Column(name = "sobrenome", length = 50, nullable = false)
    private String lastName;

    @Getter
    @Column(name = "contato", length = 50, nullable = false)
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

    @Getter
    @Column(name = "espaço-físico", length = 50, nullable = false)
    private String physicalSpace;

    @Getter
    @Column(name = "gastos", length = 50, nullable = false)
    private String spending;

    @Getter
    @Column(name = "capacidade-animais", length = 50, nullable = false)
    private Double capacityAnimals;

    @ManyToMany(mappedBy = "caregiver")
    private List<Occurrence> occurrence;

    @OneToOne
    @Getter
    @Setter
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    public void setFirstName(String firstName) {
        if(firstName == null) {
            throw new RuntimeException("O primeiro nome do protetor inserido é nulo");
        } else if (firstName.isEmpty()) {
            throw new RuntimeException("O primeiro nome do protetor inserido está vazio");
        } else if (firstName.trim().length() < 3) {
            throw new RuntimeException("O primeiro nome do protetor inserido é muito curto");
        } else if (firstName.trim().length() > 30) {
            throw new RuntimeException("O primeiro nome do protetor inserido ultrapassa o limite máximo");
        } else if (firstName.matches("[0-9]+")) {
            throw new RuntimeException("O primeiro nome do protetor inserido é composto por números");
        }
        else {
            this.firstName = firstName;
        }
    }

    public void setLastName(String lastName) {
        if(lastName == null) {
            throw new RuntimeException("O sobrenome do protetor inserido é nulo");
        } else if (lastName.isEmpty()) {
            throw new RuntimeException("O sobrenome do protetor inserido está vazio");
        } else if (lastName.trim().length() < 2) {
            throw new RuntimeException("O sobrenome do protetor inserido é muito curto");
        } else if (lastName.trim().length() > 50) {
            throw new RuntimeException("O sobrenome do protetor inserido ultrapassa o limite máximo");
        } else if (lastName.matches("[0-9]+")) {
            throw new RuntimeException("O sobrenome do protetor inserido é composto por números");
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

    public void setPhysicalSpace(String physicalSpace) {
        if(physicalSpace == null) {
            throw new RuntimeException("O espaço físico nome do protetor inserido é nulo");
        } else if (physicalSpace.isEmpty()) {
            throw new RuntimeException("O espaço físico do protetor inserido está vazio");
        } else if (physicalSpace.trim().length() < 3) {
            throw new RuntimeException("O espaço físico do protetor inserido é muito curto");
        } else if (physicalSpace.trim().length() > 35) {
            throw new RuntimeException("O pespaço físico do protetor inserido ultrapassa o limite máximo");
        } else {
            this.physicalSpace = physicalSpace;
        }
    }

    public void setSpending(String spending) {
        if(spending == null) {
            throw new RuntimeException("Os gastos do protetor inserido é nulo");
        } else if (spending.isEmpty()) {
            throw new RuntimeException("Os gastos do protetor inserido está vazio");
        } else if (spending.trim().length() < 2) {
            throw new RuntimeException("Os gastos do protetor inserido é muito curto");
        } else if (spending.trim().length() > 35) {
            throw new RuntimeException("Os gastos do protetor inserido ultrapassa o limite máximo");
        } else {
            this.spending = spending;
        }
    }

    public void setCapacityAnimals(Double capacityAnimals) {
        if(capacityAnimals == null) {
            throw new RuntimeException("A capacidade de animais inserida tem o valor nulo");
        } else if (capacityAnimals < 0) {
            throw new RuntimeException("A capacidade de animais inserida é menor que 0");
        } else if (capacityAnimals > 1000000000) {
            throw new RuntimeException("A capacidade de animais inserida ultrapassa o limite máximo de caracteres");
        }
        else {
            this.capacityAnimals = capacityAnimals;
        }
    }
}
