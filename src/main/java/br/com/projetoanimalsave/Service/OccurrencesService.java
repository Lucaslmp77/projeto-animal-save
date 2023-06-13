package br.com.projetoanimalsave.Service;

import br.com.projetoanimalsave.Entity.Occurrence;
import br.com.projetoanimalsave.Repository.OccurrenceRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OccurrencesService {
    @Autowired
    private OccurrenceRepository occurrencesRepository;

    @Transactional
    public Occurrence save(Occurrence occurrences) {
        return this.occurrencesRepository.save(occurrences);
    }

    public List<Occurrence> listAll() {
        return this.occurrencesRepository.findAll();
    }

    public Occurrence findById(Long id) {
        return this.occurrencesRepository.findById(id).orElse(new Occurrence());
    }

    @Transactional
    public void update(Occurrence occurrences, Long id) {
        if (id == occurrences.getId()) {
            this.occurrencesRepository.save(occurrences);
        } else {
            throw new RuntimeException();
        }
    }

    @Transactional
    public void disable(Long id) {
        var occurrences = this.occurrencesRepository.findById(id);
        if (id == occurrences.get().getId()) {
            this.occurrencesRepository.disable(id);
        } else {
            throw new RuntimeException();
        }
    }
}
