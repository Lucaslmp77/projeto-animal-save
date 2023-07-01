package br.com.projetoanimalsave.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "tb_ocorrências", schema = "projeto-animal-save")
public class Occurrence extends AbstractEntity {
    @Getter
    @Column(name = "nome", length = 50, nullable = false)
    private String name;

    @Getter
    @Column(name = "contato", length = 50, nullable = false)
    private String contact;

    @Getter
    @Column(name = "descrição", length = 155, nullable = false)
    private String description;

    @Getter
    @Column(name = "ponto-referência", length = 155, nullable = false)
    private String referenceLocal;

    @Getter
    @Setter
    @Column(name = "situação", length = 40, nullable = false)
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

    public void setName(String name) {
        if(name == null) {
            throw new RuntimeException("O nome registrado na ocorrência inserido é nulo");
        } else if (name.isEmpty()) {
            throw new RuntimeException("O nome registrado na ocorrência inserido está vazio");
        } else if (name.trim().length() < 3) {
            throw new RuntimeException("O nome registrado na ocorrência inserido é muito curto");
        } else if (name.trim().length() > 40) {
            throw new RuntimeException("O nome registrado na ocorrência inserido ultrapassa o limite máximo");
        } else if (name.matches("[0-9]+")) {
            throw new RuntimeException("O nome registrado na ocorrência inserido é composto por números");
        }
        else {
            this.name = name;
        }
    }

    public void setContact(String contact) {
        if(contact == null) {
            throw new RuntimeException("O contato inserido é nulo");
        } else if (contact.isEmpty()) {
            throw new RuntimeException("O contato inserido está vazio");
        } else if (contact.trim().length() < 5) {
            throw new RuntimeException("O contato inserido é muito curto");
        } else if (contact.trim().length() > 25) {
            throw new RuntimeException("O contato do associado inserido ultrapassa o limite máximo");
        } else {
            this.contact = contact;
        }
    }

    public void setDescription(String description) {
        if(description == null) {
            throw new RuntimeException("A descrição registrada na ocorrência inserido é nulo");
        } else if (description.isEmpty()) {
            throw new RuntimeException("A descrição registrada na ocorrência inserido está vazio");
        } else if (description.trim().length() < 3) {
            throw new RuntimeException("A descrição registrada na ocorrência inserido é muito curto");
        } else if (description.trim().length() > 200) {
            throw new RuntimeException("A descrição registrada na ocorrência inserido ultrapassa o limite máximo");
        } else if (description.matches("[0-9]+")) {
            throw new RuntimeException("A descrição registrada na ocorrência inserido é composto por números");
        }
        else {
            this.description = description;
        }
    }

    public void setReferenceLocal(String referenceLocal) {
        if(referenceLocal == null) {
            throw new RuntimeException("A referência registrada na ocorrência inserido é nulo");
        } else if (referenceLocal.isEmpty()) {
            throw new RuntimeException("A referência registrada na ocorrência inserido está vazio");
        } else if (referenceLocal.trim().length() < 3) {
            throw new RuntimeException("A referência registrada na ocorrência inserido é muito curto");
        } else if (referenceLocal.trim().length() > 100) {
            throw new RuntimeException("A referência registrada na ocorrência inserido ultrapassa o limite máximo");
        } else if (referenceLocal.matches("[0-9]+")) {
            throw new RuntimeException("A referência registrada na ocorrência inserido é composto por números");
        }
        else {
            this.referenceLocal = referenceLocal;
        }
    }
}
