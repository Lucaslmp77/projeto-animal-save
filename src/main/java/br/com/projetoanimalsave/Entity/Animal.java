package br.com.projetoanimalsave.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "tb_animais", schema = "projeto-animal-save")
public class Animal extends AbstractEntity {
    @Getter
    @Setter
    @Length(min = 3, max = 25, message = "O nome deve ter no mínimo {min} caracteres e no maximo {max} caracteres")
    @Column(name = "nome", length = 25, nullable = false)
    private String name;

    @Getter
    @Setter
    @Length(min = 3, max = 25, message = "A raça deve ter no mínimo {min} caracteres e no maximo {max} caracteres")
    @Column(name = "raça", length = 25, nullable = false)
    private String breed;

    @OneToOne
    @Getter
    @Setter
    @JoinColumn(name = "vaccination_id", referencedColumnName = "id", nullable = false)
    private Vaccination vaccination;

    @Getter
    @Setter
    @Column(name = "animal_type", length = 20, nullable = false)
    @Enumerated(EnumType.STRING)
    private AnimalType animalType;

    @Getter
    @Setter
    @Column(name = "animal_size", length = 20, nullable = false)
    @Enumerated(EnumType.STRING)
    private AnimalSize animalSize;

    @Getter
    @Setter
    @Length(min = 3, max = 25, message = "A cor deve ter no mínimo {min} caracteres e no maximo {max} caracteres")
    @Column(name = "cor", length = 40, nullable = false)
    private String color;

    @Getter
    @Setter
    @Column(name = "idade", length = 25, nullable = false)
    private Integer age;

    @Getter
    @Setter
    @Length(min = 3, max = 100, message = "A observação deve ter no mínimo {min} caracteres e no maximo {max} caracteres")
    @Column(name = "observação", length = 200, nullable = false)
    private String observation;

    @ManyToOne
    @Getter
    @Setter
    @JoinColumn(name="caregiver_id", nullable = false)
    private Caregiver caregiver;
}
