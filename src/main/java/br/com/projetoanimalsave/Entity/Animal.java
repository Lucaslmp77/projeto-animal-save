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

    @Getter @Setter
    @JoinColumn(name = "id_vacina", nullable = false)
    @ManyToOne
    private Vaccination vaccination;

    @Getter @Setter
    @Column(name = "animal_type", length = 10, nullable = false)
    @Enumerated(EnumType.STRING)
    private AnimalType animalType;

    @Getter @Setter
    @Column(name = "animal_size", length = 10, nullable = false)
    @Enumerated(EnumType.STRING)
    private AnimalSize animalSize;

    @Getter
    @Setter
    @Length(min = 3, max = 25, message = "A cor deve ter no mínimo {min} caracteres e no maximo {max} caracteres")
    @Column(name = "cor", length = 25, nullable = false)
    private String color;

    @Getter
    @Setter
    @Length(min = 3, max = 25, message = "A idade deve ter no mínimo {min} caracteres e no maximo {max} caracteres")
    @Column(name = "idade", length = 25, nullable = false)
    private Integer age;

    @Getter
    @Setter
    @Length(min = 3, max = 100, message = "A observação deve ter no mínimo {min} caracteres e no maximo {max} caracteres")
    @Column(name = "observação", length = 100, nullable = false)
    private String observation;

    @Getter @Setter
    @JoinColumn(name = "id_cuidador", nullable = false)
    @ManyToOne
    private Caregiver caregiver;
}
