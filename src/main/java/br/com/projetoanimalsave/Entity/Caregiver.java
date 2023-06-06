package br.com.projetoanimalsave.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "tb_cuidadores", schema = "projeto-animal-save")
public class Caregiver extends AbstractEntity {
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

    @Getter
    @Setter
    @Length(min = 5, max = 25, message = "O campo de espaço físico deve ter no mínimo {min} caracteres e no maximo {max} caracteres")
    @Column(name = "espaço-físico", length = 25, nullable = false)
    private String physicalSpace;

    @Getter
    @Setter
    @Column(name = "gastos", length = 10, nullable = true)
    private float spending;

    @Getter
    @Setter
    @Column(name = "capacidade-animais", length = 10, nullable = false)
    private Integer capacityAnimals;

    @Getter @Setter
    @Column(name = "aprovação", length = 15, nullable = false)
    @Enumerated(EnumType.STRING)
    private Aprove aprove;

    @Getter @Setter
    @JoinColumn(name = "id_ocorrência", nullable = true)
    @ManyToOne
    private Occurrences occurrences;

    @Getter @Setter
    @JoinColumn(name = "id_animal", nullable = true)
    @OneToMany
    private List<Animal> animal;

    @ManyToMany
    @JoinTable(name = "tb_caregiver_role",
            joinColumns = @JoinColumn(name = "caregiver_id"),
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
