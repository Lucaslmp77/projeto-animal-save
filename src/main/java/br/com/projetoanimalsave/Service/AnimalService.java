package br.com.projetoanimalsave.Service;

import br.com.projetoanimalsave.Entity.*;
import br.com.projetoanimalsave.Repository.AnimalRepository;
import br.com.projetoanimalsave.Repository.VaccinationRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalService {
    @Autowired
    private AnimalRepository animalRepository;

    @Autowired
    private VaccinationRepository vaccinationRepository;

    @Transactional
    public Animal save(Animal animal) {
        Vaccination vaccination = new Vaccination();
        vaccination.setRabies(animal.getVaccination().getRabies());
        vaccination.setCanineParvovirus(animal.getVaccination().getCanineParvovirus());
        vaccination.setDistemper(animal.getVaccination().getDistemper());
        vaccination.setCanineHepatitis(animal.getVaccination().getCanineHepatitis());
        this.vaccinationRepository.save(vaccination);

        animal.setVaccination(vaccination);
        return this.animalRepository.save(animal);
    }

    public List<Animal> listAll() {
        return this.animalRepository.findAll();
    }

    public Animal findById(Long id) {
        return this.animalRepository.findById(id).orElse(new Animal());
    }

    public List<Animal> findAnimalByIdCaregiver(Long id) {
        return this.animalRepository.findAnimalByIdCaregiver(id);
    }

    @Transactional
    public void update(Animal animal, Long id) {
        if (id == animal.getId()) {
            animal.getVaccination().setRabies(animal.getVaccination().getRabies());
            animal.getVaccination().setCanineParvovirus(animal.getVaccination().getCanineParvovirus());
            animal.getVaccination().setDistemper(animal.getVaccination().getDistemper());
            animal.getVaccination().setCanineHepatitis(animal.getVaccination().getCanineHepatitis());
            this.vaccinationRepository.save(animal.getVaccination());
            animal.setVaccination(animal.getVaccination());
            this.animalRepository.save(animal);
        } else {
            throw new RuntimeException();
        }
    }

    @Transactional
    public void disable(Long id) {
        var animal = this.animalRepository.findById(id);
        if (id == animal.get().getId()) {
            this.animalRepository.disable(id);
        } else {
            throw new RuntimeException();
        }
    }
}
