package br.com.projetoanimalsave.Service;

import br.com.projetoanimalsave.Entity.Vaccination;
import br.com.projetoanimalsave.Repository.VaccinationRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VaccinationService {
    @Autowired
    private VaccinationRepository vaccinationRepository;

    @Transactional
    public Vaccination save(Vaccination vaccination) {
        return this.vaccinationRepository.save(vaccination);
    }

    public List<Vaccination> listAll() {
        return this.vaccinationRepository.findAll();
    }

    public Vaccination findById(Long id) {
        return this.vaccinationRepository.findById(id).orElse(new Vaccination());
    }

    @Transactional
    public void update(Vaccination vaccination, Long id) {
        if (id == vaccination.getId()) {
            this.vaccinationRepository.save(vaccination);
        } else {
            throw new RuntimeException();
        }
    }
}
