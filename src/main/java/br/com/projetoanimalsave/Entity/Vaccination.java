package br.com.projetoanimalsave.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_vacinas", schema = "projeto-animal-save")
public class Vaccination extends AbstractEntity {
    @Getter
    @Setter
    @Column(name = "raiva", nullable = false)
    private Boolean rabies;

    @Getter
    @Setter
    @Column(name = "parvovírus-canino", nullable = false)
    private Boolean canineParvovirus;

    @Getter
    @Setter
    @Column(name = "cinomose", nullable = false)
    private Boolean distemper;

    @Getter
    @Setter
    @Column(name = "hepatite-canina", nullable = false)
    private Boolean canineHepatitis;

    @Getter
    @Setter
    @OneToOne(mappedBy = "vaccination")
    private Animal animal;
}
