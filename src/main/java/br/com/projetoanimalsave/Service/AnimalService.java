package br.com.projetoanimalsave.Service;

import br.com.projetoanimalsave.Entity.Animal;
import br.com.projetoanimalsave.Repository.AnimalRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalService {
    @Autowired
    private AnimalRepository animalRepository;

    @Transactional
    public Animal save(Animal animal) {
        return this.animalRepository.save(animal);
    }

    public List<Animal> listAll() {
        return this.animalRepository.findAll();
    }

    public Animal findById(Long id) {
        return this.animalRepository.findById(id).orElse(new Animal());
    }

    @Transactional
    public void update(Animal animal, Long id) {
        if (id == animal.getId()) {
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
