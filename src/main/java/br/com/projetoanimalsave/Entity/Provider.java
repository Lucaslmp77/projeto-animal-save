package br.com.projetoanimalsave.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CNPJ;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "tb_fornecedores", schema = "projeto-animal-save")
public class Provider implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    @Column(name = "id", length = 30, nullable = false, unique = true)
    private Long id;

    @Getter @Setter
    @Column(name = "active", nullable = false)
    private Boolean active;

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
    @Column(name = "login", length = 40, nullable = false, unique = true)
    private String login;

    @Getter
    @Setter
    @Column(name = "senha", length = 90, nullable = false)
    private String password;

    @Getter @Setter
    @Column(name = "contato", length = 14, nullable = false)
    private String contact;

    @Getter @Setter
    @JoinColumn(name = "id_endereço", nullable = true)
    @ManyToOne
    private Address address;

    @Getter @Setter
    @JoinColumn(name = "id_serviço", nullable = true)
    @ManyToOne
    private Task service;

    @Getter @Setter
    @Column(name = "aprovação", length = 15, nullable = true)
    @Enumerated(EnumType.STRING)
    private Aprove aprove;

    @Getter @Setter
    @JoinColumn(name = "id_ocorrência", nullable = true)
    @ManyToOne
    private Occurrences occurrences;

    @ManyToMany(fetch = FetchType.EAGER)
    @Getter
    @Setter
    @JoinTable(name = "tb_provider_role",
            joinColumns = @JoinColumn(name = "provider_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return role;
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
