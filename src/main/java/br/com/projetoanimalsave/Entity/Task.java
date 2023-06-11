package br.com.projetoanimalsave.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "tb_serviços", schema = "projeto-animal-save")
public class Task extends AbstractEntity {
    @Getter
    @Setter
    @Length(min = 3, max = 25, message = "O nome deve ter no mínimo {min} caracteres e no maximo {max} caracteres")
    @Column(name = "nome", length = 25, nullable = false)
    private String name;

    @Getter
    @Setter
    @Column(name = "custo", length = 25, nullable = false)
    private Integer cost;

    @Getter
    @Setter
    @Column(name = "valor-mensal", length = 25, nullable = false)
    private Integer monthlyAmount;

    @Getter
    @Setter
    @Length(min = 5, max = 100, message = "A descrição deve ter no mínimo {min} caracteres e no maximo {max} caracteres")
    @Column(name = "descrição", length = 100, nullable = false)
    private String drescription;

    @ManyToOne
    @Getter
    @Setter
    @JoinColumn(name="provider_id", nullable = false)
    private Provider provider;
}
