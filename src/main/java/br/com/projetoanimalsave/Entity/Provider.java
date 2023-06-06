package br.com.projetoanimalsave.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CNPJ;

import java.util.HashSet;
import java.util.Set;

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

    @Getter@Setter
    @Email
    @Column(name = "email", length = 40, nullable = false, unique = true)
    private String email;

    @Getter
    @Setter
    @Length(min = 3, max = 25, message = "A senha deve ter no mínimo {min} caracteres e no maximo {max} caracteres")
    @Column(name = "senha", length = 25, nullable = false)
    private String password;

    @Getter @Setter
    @Column(name = "contato", length = 14, nullable = false)
    private String contact;

    @Getter @Setter
    @JoinColumn(name = "id_endereço", nullable = false)
    @ManyToOne
    private Address address;

    @Getter @Setter
    @JoinColumn(name = "id_serviço", nullable = false)
    @ManyToOne
    private Task service;

    @Getter @Setter
    @Column(name = "aprovação", length = 15, nullable = false)
    @Enumerated(EnumType.STRING)
    private Aprove aprove;

    @Getter @Setter
    @JoinColumn(name = "id_ocorrência", nullable = false)
    @ManyToOne
    private Occurrences occurrences;

    @ManyToMany
    @JoinTable(name = "tb_provider_role",
            joinColumns = @JoinColumn(name = "provider_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    public void addRole (Role role) {
        roles.add(role);
    }

    public boolean hasRole(String roleName) {
        for (Role role : roles) {
            if (role.getAuthority().equals(roleName)) {
                return true;
            }
        }
        return false;
    }
}
