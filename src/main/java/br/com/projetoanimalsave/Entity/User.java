package br.com.projetoanimalsave.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_user", schema = "projeto-animal-save")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    @Column(name = "id", length = 50, nullable = false, unique = true)
    private Long id;

    @Getter
    @Setter
    @Email
    @Column(name = "login", length = 50, nullable = false, unique = true)
    private String login;

    @Getter
    @Setter
    @Column(name = "primeira-credencial", length = 90)
    private String firstCredential;

    @Getter
    @Setter
    @Column(name = "senha", length = 150, nullable = false)
    private String password;

    @Getter
    @Setter
    @Column(name = "aprovado", length = 50, nullable = false)
    private Boolean approved;

    @Getter
    @Setter
    @Column(name = "pendente", length = 50, nullable = false)
    private Boolean pending;

    @Getter
    @Setter
    @Column(name = "rejeitado", length = 50, nullable = false)
    private Boolean rejected;

    @OneToOne(mappedBy = "user")
    private Admin admin;

    @OneToOne(mappedBy = "user")
    private Caregiver caregiver;

    @OneToOne(mappedBy = "user")
    private Provider provider;

    @OneToOne(mappedBy = "user")
    private Associate associate;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "tb_user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @Override
    public String getPassword() {
        return password;
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
