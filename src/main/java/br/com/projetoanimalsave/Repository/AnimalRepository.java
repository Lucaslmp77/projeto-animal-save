package br.com.projetoanimalsave.Repository;

import br.com.projetoanimalsave.Entity.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> {
    @Modifying
    @Query("UPDATE Animal animal SET animal.active = false WHERE animal.id = :id")
    public void disable(@Param("id") Long id);
}
