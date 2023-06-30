package br.com.projetoanimalsave.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_endereços", schema = "projeto-animal-save")
public class Address extends AbstractEntity {
    @Getter
    @Setter
    @Column(name = "cep", length = 90, nullable = false)
    private String cep;

    @Getter
    @Setter
    @Column(name = "bairro", length = 90, nullable = false)
    private String neighborhood;

    @Getter
    @Setter
    @Column(name = "rua", length = 90, nullable = false)
    private String road;

    @Getter
    @Setter
    @Column(name = "número", length = 25, nullable = false)
    private Integer houseNumber;

    @Getter
    @Setter
    @OneToOne(mappedBy = "address")
    private Associate associate;

    @Getter
    @Setter
    @OneToOne(mappedBy = "address")
    private Caregiver caregiver;

    @Getter
    @Setter
    @OneToOne(mappedBy = "address")
    private Provider provider;
}
