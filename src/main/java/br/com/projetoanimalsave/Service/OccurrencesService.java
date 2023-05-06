package br.com.projetoanimalsave.Service;

import br.com.projetoanimalsave.Entity.Occurrences;
import br.com.projetoanimalsave.Repository.OccurrencesRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OccurrencesService {
    @Autowired
    private OccurrencesRepository occurrencesRepository;

    @Transactional
    public Occurrences save(Occurrences occurrences) {
        return this.occurrencesRepository.save(occurrences);
    }

    public List<Occurrences> listAll() {
        return this.occurrencesRepository.findAll();
    }

    public Occurrences findById(Long id) {
        return this.occurrencesRepository.findById(id).orElse(new Occurrences());
    }

    @Transactional
    public void update(Occurrences occurrences, Long id) {
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
