package br.com.projetoanimalsave.Repository;

import br.com.projetoanimalsave.Entity.Occurrences;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OccurrencesRepository extends JpaRepository<Occurrences, Long> {
}
