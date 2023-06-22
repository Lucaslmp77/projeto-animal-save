package br.com.projetoanimalsave.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "tb_ocorrências", schema = "projeto-animal-save")
public class Occurrence extends AbstractEntity {
    @Getter
    @Setter
    @Column(name = "nome", length = 25, nullable = false)
    private String name;

    @Getter
    @Setter
    @Column(name = "contato", length = 14, nullable = false)
    private String contact;

    @Getter
    @Setter
    @Column(name = "descrição", length = 100, nullable = false)
    private String description;

    @Getter
    @Setter
    @Column(name = "ponto-referência", length = 100, nullable = false)
    private String referenceLocal;

    @Getter
    @Setter
    @Column(name = "situação", length = 10, nullable = false)
    @Enumerated(EnumType.STRING)
    private Situation situation;

    @ManyToMany
    @Getter
    @Setter
    @JoinTable(
            name = "occurrence_caregiver",
            joinColumns = @JoinColumn(name = "occurrence_id"),
            inverseJoinColumns = @JoinColumn(name = "caregiver_id"))
    private List<Caregiver> caregiver;
}
