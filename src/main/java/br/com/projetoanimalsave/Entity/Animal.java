package br.com.projetoanimalsave.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_animais", schema = "projeto-animal-save")
public class Animal extends AbstractEntity {
    @Getter
    @Setter
    @Column(name = "nome", length = 25, nullable = false)
    private String name;

    @Getter
    @Setter
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
    @Column(name = "cor", length = 40, nullable = false)
    private String color;

    @Getter
    @Setter
    @Column(name = "idade", length = 25, nullable = false)
    private Integer age;

    @Getter
    @Setter
    @Column(name = "observação", length = 200, nullable = false)
    private String observation;

    @ManyToOne
    @Getter
    @Setter
    @JoinColumn(name="caregiver_id", nullable = false)
    private Caregiver caregiver;
}
