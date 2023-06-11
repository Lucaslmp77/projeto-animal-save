package br.com.projetoanimalsave.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.util.List;

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

    @ManyToMany
    @Getter
    @Setter
    @JoinTable(
            name = "animal_vacina",
            joinColumns = @JoinColumn(name = "animal_id"),
            inverseJoinColumns = @JoinColumn(name = "vacina_id"))
    private List<Vaccination> vaccination;

    @Getter
    @Setter
    @Column(name = "animal_type", length = 10, nullable = false)
    @Enumerated(EnumType.STRING)
    private AnimalType animalType;

    @Getter
    @Setter
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
    @Column(name = "idade", length = 25, nullable = false)
    private Integer age;

    @Getter
    @Setter
    @Length(min = 3, max = 100, message = "A observação deve ter no mínimo {min} caracteres e no maximo {max} caracteres")
    @Column(name = "observação", length = 100, nullable = false)
    private String observation;

    @ManyToOne
    @Getter
    @Setter
    @JoinColumn(name="caregiver_id", nullable = false)
    private Caregiver caregiver;
}
