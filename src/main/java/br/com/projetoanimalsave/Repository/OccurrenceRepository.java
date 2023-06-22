package br.com.projetoanimalsave.Repository;

import br.com.projetoanimalsave.Entity.Occurrence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OccurrenceRepository extends JpaRepository<Occurrence, Long> {
    @Modifying
    @Query("UPDATE Occurrence occurrence SET occurrence.active = false WHERE occurrence.id = :id")
    public void disable(@Param("id") Long id);

    @Query("SELECT occurrence FROM Occurrence occurrence where occurrence.active = false")
    public List<Occurrence> findByOccurrenceInactives();

    @Query("SELECT occurrence FROM Occurrence occurrence where occurrence.active = true")
    public List<Occurrence> findByOccurrenceActives();
}
