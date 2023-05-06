package br.com.projetoanimalsave.Repository;

import br.com.projetoanimalsave.Entity.Occurrences;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OccurrencesRepository extends JpaRepository<Occurrences, Long> {
    @Modifying
    @Query("UPDATE Occurrences occurrences SET occurrences.active = false WHERE occurrences.id = :id")
    public void disable(@Param("id") Long id);
}
