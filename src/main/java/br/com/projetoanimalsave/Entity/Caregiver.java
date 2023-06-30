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
    @Setter
    @Column(name = "nome", length = 50, nullable = false)
    private String firstName;

    @Getter
    @Setter
    @Column(name = "sobrenome", length = 50, nullable = false)
    private String lastName;

    @Getter
    @Setter
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
    @Setter
    @Column(name = "espaço-físico", length = 50, nullable = false)
    private String physicalSpace;

    @Getter
    @Setter
    @Column(name = "gastos", length = 50, nullable = false)
    private String spending;

    @Getter
    @Setter
    @Column(name = "capacidade-animais", length = 50, nullable = false)
    private Double capacityAnimals;

    @ManyToMany(mappedBy = "caregiver")
    private List<Occurrence> occurrence;

    @OneToOne
    @Getter
    @Setter
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
}
