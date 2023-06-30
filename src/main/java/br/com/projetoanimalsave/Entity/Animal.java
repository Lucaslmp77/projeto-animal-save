package br.com.projetoanimalsave.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_animais", schema = "projeto-animal-save")
public class Animal extends AbstractEntity {
    @Getter
    @Column(name = "nome", length = 25, nullable = false)
    private String name;

    @Getter
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
    @Column(name = "cor", length = 40, nullable = false)
    private String color;

    @Getter
    @Column(name = "idade", length = 25, nullable = false)
    private Integer age;

    @Getter
    @Setter
    @Column(name = "observação", length = 200)
    private String observation;

    @ManyToOne
    @Getter
    @Setter
    @JoinColumn(name="caregiver_id", nullable = false)
    private Caregiver caregiver;

    public void setName(String name) {
        if(name == null) {
            throw new RuntimeException("O nome do animal inserido é nulo");
        } else if (name.isEmpty()) {
            throw new RuntimeException("O nome do animal inserido está vazio");
        } else if (name.trim().length() < 3) {
            throw new RuntimeException("O nome do animal inserido é muito curto");
        } else if (name.trim().length() > 25) {
            throw new RuntimeException("O nome do animal inserido ultrapassa o limite máximo");
        } else if (name.matches("[0-9]+")) {
            throw new RuntimeException("O nome do animal inserido é composto por números");
        }
        else {
            this.name = name;
        }
    }

    public void setBreed(String breed) {
        if(breed == null) {
            throw new RuntimeException("A raça do animal inserida é nulo");
        } else if (breed.isEmpty()) {
            throw new RuntimeException("A raça do animal inserida está vazio");
        } else if (breed.trim().length() < 3) {
            throw new RuntimeException("A raça do animal inserida é muito curta");
        } else if (breed.trim().length() > 25) {
            throw new RuntimeException("A raça do animal inserida ultrapassa o limite máximo");
        } else if (breed.matches("[0-9]+")) {
            throw new RuntimeException("A raça do animal inserida é composta por números");
        }
        else {
            this.breed = breed;
        }
    }

    public void setColor(String color) {
        if(color == null) {
            throw new RuntimeException("A cor do animal inserida é nulo");
        } else if (color.isEmpty()) {
            throw new RuntimeException("A cor do animal inserida está vazio");
        } else if (color.trim().length() < 2) {
            throw new RuntimeException("A cor do animal inserida é muito curta");
        } else if (color.trim().length() > 25) {
            throw new RuntimeException("A cor do animal inserida ultrapassa o limite máximo");
        } else if (color.matches("[0-9]+")) {
            throw new RuntimeException("A cor do animal inserida é composta por números");
        }
        else {
            this.color = color;
        }
    }

    public void setAge(Integer age) {
        if(age == null) {
            throw new RuntimeException("A idade do animal inserida tem o valor nulo");
        } else if (age < 0) {
            throw new RuntimeException("A idade do animal inserida é menor que 0");
        } else if (age > 1000000000) {
            throw new RuntimeException("A idade do animal inserida ultrapassa o limite máximo de caracteres");
        }
        else {
            this.age = age;
        }
    }
}
