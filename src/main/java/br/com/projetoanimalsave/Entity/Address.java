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
    @Column(name = "cep", length = 90, nullable = false)
    private String cep;

    @Getter
    @Column(name = "bairro", length = 90, nullable = false)
    private String neighborhood;

    @Getter
    @Column(name = "rua", length = 90, nullable = false)
    private String road;

    @Getter
    @Column(name = "número", length = 25, nullable = false)
    private Integer houseNumber;

    public void setCep(String cep) {
        if(cep == null) {
            throw new RuntimeException("O cep inserido é nulo");
        } else if (cep.isEmpty()) {
            throw new RuntimeException("O cep inserido está vazio");
        } else if (cep.trim().length() < 8) {
            throw new RuntimeException("O cep inserido é muito curto");
        } else if (cep.trim().length() > 8) {
            throw new RuntimeException("O nome do administrador inserido ultrapassa o limite máximo");
        } else {
            this.cep = cep;
        }
    }

    public void setNeighborhood(String neighborhood) {
        if(neighborhood == null) {
            throw new RuntimeException("O bairro inserido é nulo");
        } else if (neighborhood.isEmpty()) {
            throw new RuntimeException("O bairro inserido está vazio");
        } else if (neighborhood.trim().length() < 2) {
            throw new RuntimeException("O bairro inserido é muito curto");
        } else if (neighborhood.trim().length() > 60) {
            throw new RuntimeException("O bairro inserido ultrapassa o limite máximo");
        } else if (neighborhood.matches("[0-9]+")) {
            throw new RuntimeException("O bairro inserido é composto por números");
        }
        else {
            this.neighborhood = neighborhood;
        }
    }

    public void setRoad(String road) {
        if(road == null) {
            throw new RuntimeException("A rua inserida tem o valor nulo");
        } else if (road.isEmpty()) {
            throw new RuntimeException("A rua inserida está vazia");
        } else if (road.trim().length() < 2) {
            throw new RuntimeException("A rua inserida é muito curta");
        } else if (road.trim().length() > 70) {
            throw new RuntimeException("A rua inserida ultrapassa o limite máximo de caracteres");
        } else if (road.matches("[0-9]+")) {
            throw new RuntimeException("A rua inserida é composta por números");
        }
        else {
            this.road = road;
        }
    }

    public void setHouseNumber(Integer houseNumber) {
        if(houseNumber == null) {
            throw new RuntimeException("O número inserido tem o valor nulo");
        } else if (houseNumber < 0) {
            throw new RuntimeException("O número inserido é menor que 0");
        } else if (houseNumber > 1000000000) {
            throw new RuntimeException("O número inserido ultrapassa o limite máximo de caracteres");
        }
        else {
            this.houseNumber = houseNumber;
        }
    }

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
