package br.com.projetoanimalsave.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_serviços", schema = "projeto-animal-save")
public class Task extends AbstractEntity {
    @Getter
    @Setter
    @Column(name = "nome", length = 50, nullable = false)
    private String name;

    @Getter
    @Setter
    @Column(name = "custo", length = 50, nullable = false)
    private Integer cost;

    @Getter
    @Setter
    @Column(name = "valor-mensal", length = 50, nullable = false)
    private Integer monthlyAmount;

    @Getter
    @Setter
    @Column(name = "descrição", length = 200, nullable = false)
    private String description;

    @ManyToOne
    @Getter
    @Setter
    @JoinColumn(name="provider_id", nullable = false)
    private Provider provider;
}
