package br.com.projetoanimalsave.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_serviços", schema = "projeto-animal-save")
public class Task extends AbstractEntity {
    @Getter
    @Column(name = "nome", length = 50, nullable = false)
    private String name;

    @Getter
    @Column(name = "custo", length = 50, nullable = false)
    private Integer cost;

    @Getter
    @Column(name = "valor-mensal", length = 50, nullable = false)
    private Integer monthlyAmount;

    @Getter
    @Column(name = "descrição", length = 200, nullable = false)
    private String description;

    @ManyToOne
    @Getter
    @Setter
    @JoinColumn(name="provider_id", nullable = false)
    private Provider provider;

    public void setName(String name) {
        if(name == null) {
            throw new RuntimeException("O nome do serviço inserido é nulo");
        } else if (name.isEmpty()) {
            throw new RuntimeException("O nome do serviço inserido está vazio");
        } else if (name.trim().length() < 3) {
            throw new RuntimeException("O nome do serviço inserido é muito curto");
        } else if (name.trim().length() > 30) {
            throw new RuntimeException("O nome do serviço inserido ultrapassa o limite máximo");
        } else if (name.matches("[0-9]+")) {
            throw new RuntimeException("O nome do serviço inserido é composto por números");
        }
        else {
            this.name = name;
        }
    }

    public void setCost(Integer cost) {
        if(cost == null) {
            throw new RuntimeException("O custo inserido tem o valor nulo");
        } else if (cost < 0) {
            throw new RuntimeException("O custo inserido é menor que 0");
        } else if (cost > 1000000000) {
            throw new RuntimeException("O custo inserido ultrapassa o limite máximo de caracteres");
        }
        else {
            this.cost = cost;
        }
    }

    public void setMonthlyAmount(Integer monthlyAmount) {
        if(monthlyAmount == null) {
            throw new RuntimeException("A quantidade mensal inserida tem o valor nulo");
        } else if (monthlyAmount < 0) {
            throw new RuntimeException("A quantidade mensal inserida é menor que 0");
        } else if (monthlyAmount > 1000000000) {
            throw new RuntimeException("A quantidade mensal inserida o limite máximo de caracteres");
        }
        else {
            this.monthlyAmount = monthlyAmount;
        }
    }

    public void setDescription(String description) {
        if(description == null) {
            throw new RuntimeException("A descrição registrada no serviço é nulo");
        } else if (description.isEmpty()) {
            throw new RuntimeException("A descrição registrada no serviço está vazio");
        } else if (description.trim().length() < 3) {
            throw new RuntimeException("A descrição registrada no serviço é muito curto");
        } else if (description.trim().length() > 200) {
            throw new RuntimeException("A descrição registrada no serviço ultrapassa o limite máximo");
        } else if (description.matches("[0-9]+")) {
            throw new RuntimeException("A descrição registrada no serviço é composto por números");
        }
        else {
            this.description = description;
        }
    }
}
