package br.com.projetoanimalsave.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "tb_ocorrências", schema = "projeto-animal-save")
public class Occurrence extends AbstractEntity {
    @Getter
    @Setter
    @Length(min = 3, max = 25, message = "O nome deve ter no mínimo {min} caracteres e no maximo {max} caracteres")
    @Column(name = "nome", length = 25, nullable = false)
    private String name;

    @Getter
    @Setter
    @Column(name = "contato", length = 14, nullable = false)
    private String contact;

    @Getter
    @Setter
    @Length(min = 5, max = 100, message = "A descrição deve ter no mínimo {min} caracteres e no maximo {max} caracteres")
    @Column(name = "descrição", length = 100, nullable = false)
    private String description;

    @Getter
    @Setter
    @Length(min = 5, max = 100, message = "O ponto de referência deve ter no mínimo {min} caracteres e no maximo {max} caracteres")
    @Column(name = "ponto-referência", length = 100, nullable = false)
    private String referenceLocal;

    @Getter
    @Setter
    @Column(name = "situação", length = 10, nullable = false)
    @Enumerated(EnumType.STRING)
    private Situation situation;

    @ManyToOne
    @Getter
    @Setter
    @JoinColumn(name="caregiver_id", nullable = true)
    private Caregiver caregiver;
}
