package br.com.projetoanimalsave.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "tb_endereços", schema = "projeto-animal-save")
public class Address extends AbstractEntity {
    @Getter
    @Setter
    @Length(min = 3, max = 25, message = "O CEP deve ter no mínimo {min} caracteres e no maximo {max} caracteres")
    @Column(name = "cep", length = 25, nullable = false)
    private String cep;

    @Getter
    @Setter
    @Length(min = 3, max = 25, message = "O bairro deve ter no mínimo {min} caracteres e no maximo {max} caracteres")
    @Column(name = "bairro", length = 25, nullable = false)
    private String neighborhood;

    @Getter
    @Setter
    @Length(min = 3, max = 25, message = "A rua deve ter no mínimo {min} caracteres e no maximo {max} caracteres")
    @Column(name = "rua", length = 25, nullable = false)
    private String road;

    @Getter
    @Setter
    @Column(name = "número", length = 25, nullable = false)
    private Integer houseNumber;

    @OneToOne(mappedBy = "address")
    private Associate associate;
}
