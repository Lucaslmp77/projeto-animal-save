package br.com.projetoanimalsave.Service;

import br.com.projetoanimalsave.Entity.Caregiver;
import br.com.projetoanimalsave.Repository.CaregiverRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CaregiverService {
    @Autowired
    private CaregiverRepository caregiverRepository;

    @Transactional
    public Caregiver save(Caregiver caregiver) {
        return this.caregiverRepository.save(caregiver);
    }

    public List<Caregiver> listAll() {
        return this.caregiverRepository.findAll();
    }

    public Caregiver findById(Long id) {
        return this.caregiverRepository.findById(id).orElse(new Caregiver());
    }

    @Transactional
    public void update(Caregiver caregiver, Long id) {
        if (id == caregiver.getId()) {
            this.caregiverRepository.save(caregiver);
        } else {
            throw new RuntimeException();
        }
    }

    @Transactional
    public void delete(Caregiver caregiver, Long id) {
        if (id == caregiver.getId()) {
            this.caregiverRepository.delete(caregiver);
        } else {
            throw new RuntimeException();
        }
    }
}
