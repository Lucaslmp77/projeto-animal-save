package br.com.projetoanimalsave.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CNPJ;

@Entity
@Table(name = "tb_fornecedores", schema = "projeto-animal-save")
public class Provider extends AbstractEntity {

    @Getter
    @Setter
    @Length(min = 3, max = 25, message = "O nome deve ter no mínimo {min} caracteres e no maximo {max} caracteres")
    @Column(name = "nome", length = 25, nullable = false)
    private String firstName;

    @Getter
    @Setter
    @Length(min = 3, max = 25, message = "O sobrenome deve ter no mínimo {min} caracteres e no maximo {max} caracteres")
    @Column(name = "sobrenome", length = 25, nullable = false)
    private String lastName;

    @Getter
    @Setter
    @CNPJ
    @Length(min = 3, max = 25, message = "O CNPJ deve ter no mínimo {min} caracteres e no maximo {max} caracteres")
    @Column(name = "cnpj", length = 25, nullable = false)
    private String cnpj;

    @Getter
    @Setter
    @Column(name = "contato", length = 14, nullable = false)
    private String contact;

    @Getter
    @Setter
    @JoinColumn(name = "id_endereço", nullable = true)
    @ManyToOne
    private Address address;

    @Getter
    @Setter
    @JoinColumn(name = "id_serviço", nullable = true)
    @ManyToOne
    private Task service;

    @Getter
    @Setter
    @Column(name = "aprovação", length = 15, nullable = true)
    @Enumerated(EnumType.STRING)
    private Aprove aprove;

    @Getter
    @Setter
    @JoinColumn(name = "id_ocorrência", nullable = true)
    @ManyToOne
    private Occurrences occurrences;

    @OneToOne
    @Getter
    @Setter
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
}
