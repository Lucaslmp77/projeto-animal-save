package br.com.projetoanimalsave.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import java.util.List;

@Entity
@Table(name = "tb_cuidadores", schema = "projeto-animal-save")
public class Caregiver extends AbstractEntity{

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

    @OneToOne
    @Getter
    @Setter
    @JoinColumn(name = "address_id", nullable = false)
    private Address address;

    @Getter
    @Setter
    @Length(min = 5, max = 25, message = "O campo de espaço físico deve ter no mínimo {min} caracteres e no maximo {max} caracteres")
    @Column(name = "espaço-físico", length = 25, nullable = false)
    private String physicalSpace;

    @Getter
    @Setter
    @Column(name = "gastos", length = 10, nullable = true)
    private float spending;

    @Getter
    @Setter
    @Column(name = "capacidade-animais", length = 10, nullable = false)
    private Integer capacityAnimals;

    @Getter
    @Setter
    @Column(name = "aprovação", length = 15, nullable = true)
    @Enumerated(EnumType.STRING)
    private Aprove aprove;

    @Getter
    @Setter
    @JoinColumn(name = "id_ocorrência", nullable = true)
    @ManyToOne
    private Occurrences occurrences;

    @OneToMany(mappedBy = "caregiver")
    @Getter
    @Setter
    private List<Animal> animal;

    @OneToOne
    @Getter
    @Setter
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
}
