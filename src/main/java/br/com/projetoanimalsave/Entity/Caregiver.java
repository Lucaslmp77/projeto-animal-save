package br.com.projetoanimalsave.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import java.util.List;

@Entity
@Table(name = "tb_cuidadores", schema = "projeto-animal-save")
public class Caregiver extends AbstractEntity{

    @Getter
    @Setter
    @Column(name = "nome", length = 25, nullable = false)
    private String firstName;

    @Getter
    @Setter
    @Column(name = "sobrenome", length = 25, nullable = false)
    private String lastName;

    @Getter
    @Setter
    @Column(name = "contato", length = 14, nullable = false)
    private String contact;

    @Getter
    @Setter
    @CPF
    @Column(name = "cpf", length = 30, nullable = false, unique = true)
    private String cpf;

    @OneToOne
    @Getter
    @Setter
    @JoinColumn(name = "address_id", nullable = false)
    private Address address;

    @Getter
    @Setter
    @Column(name = "espaço-físico", length = 25, nullable = false)
    private String physicalSpace;

    @Getter
    @Setter
    @Column(name = "gastos", length = 20, nullable = false)
    private String spending;

    @Getter
    @Setter
    @Column(name = "capacidade-animais", length = 10, nullable = false)
    private Double capacityAnimals;

    @OneToMany(mappedBy = "caregiver")
    @Getter
    @Setter
    private List<Occurrence> occurrence;

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
