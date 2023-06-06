package br.com.projetoanimalsave.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_role", schema = "projeto-animal-save")
public class Role extends AbstractEntity {

}
