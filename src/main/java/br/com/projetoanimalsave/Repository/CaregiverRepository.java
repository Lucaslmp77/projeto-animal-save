package br.com.projetoanimalsave.Repository;

import br.com.projetoanimalsave.Entity.Caregiver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CaregiverRepository extends JpaRepository<Caregiver, Long> {
    @Modifying
    @Query("UPDATE Caregiver caregiver SET caregiver.active = false WHERE caregiver.id = :id")
    public void disable(@Param("id") Long id);
}
