package br.com.projetoanimalsave.Service;

import br.com.projetoanimalsave.Entity.Occurrence;
import br.com.projetoanimalsave.Repository.CaregiverRepository;
import br.com.projetoanimalsave.Repository.OccurrenceRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OccurrencesService {
    @Autowired
    private OccurrenceRepository occurrenceRepository;

    @Autowired
    private CaregiverRepository caregiverRepository;

    @Transactional
    public Occurrence save(Occurrence occurrences) {
        return this.occurrenceRepository.save(occurrences);
    }

    public List<Occurrence> listAll() {
        return this.occurrenceRepository.findAll();
    }

    public Occurrence findById(Long id) {
        return this.occurrenceRepository.findById(id).orElse(new Occurrence());
    }

    @Transactional
    public void update(Occurrence occurrences, Long id) {
        if (id == occurrences.getId()) {
            this.occurrenceRepository.save(occurrences);
        } else {
            throw new RuntimeException();
        }
    }

    @Transactional
    public void disable(Long id) {
        var occurrence = this.occurrenceRepository.findById(id);
        if (id == occurrence.get().getId()) {
            this.occurrenceRepository.disable(id);
        } else {
            throw new RuntimeException();
        }
    }

    public List<Occurrence> findByOccurrenceActives() {
        return this.occurrenceRepository.findByOccurrenceActives();
    }

    @Transactional
    public void respondToOccurrence(Long id) {
        var caregiver = this.caregiverRepository.findById(id);
        if (id == caregiver.get().getId()) {
            this.occurrenceRepository.respondToOccurrence(id);
        } else {
            throw new RuntimeException();
        }
    }
}
