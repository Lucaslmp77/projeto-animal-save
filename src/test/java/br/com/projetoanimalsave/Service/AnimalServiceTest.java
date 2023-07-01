package br.com.projetoanimalsave.Service;

import br.com.projetoanimalsave.Entity.Animal;
import br.com.projetoanimalsave.Entity.Vaccination;
import br.com.projetoanimalsave.Repository.AnimalRepository;
import br.com.projetoanimalsave.Repository.VaccinationRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

public class AnimalServiceTest {

    @Mock
    private AnimalRepository animalRepository;

    @Mock
    private VaccinationRepository vaccinationRepository;

    @InjectMocks
    private AnimalService animalService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSaveAnimal() {
        Animal animal = new Animal();
        animal.setName("Caramelo");
        animal.setBreed("Vira lata");
        animal.setColor("Amarelão");
        animal.setAge(5);

        Vaccination vaccination = new Vaccination();
        vaccination.setRabies(true);
        vaccination.setCanineParvovirus(true);
        vaccination.setDistemper(true);
        vaccination.setCanineHepatitis(true);

        animal.setVaccination(vaccination);

        when(vaccinationRepository.save(any(Vaccination.class))).thenReturn(vaccination);
        when(animalRepository.save(any(Animal.class))).thenReturn(animal);

        Animal savedAnimal = animalService.save(animal);

        Assertions.assertEquals(animal, savedAnimal);
        verify(vaccinationRepository, times(1)).save(any(Vaccination.class));
        verify(animalRepository, times(1)).save(any(Animal.class));
    }

    @Test
    void testListAllAnimals() {
        List<Animal> animalList = new ArrayList<>();
        Animal animal1 = new Animal();
        animal1.setName("Caramelo");
        animal1.setBreed("Vira lata");
        animalList.add(animal1);

        Animal animal2 = new Animal();
        animal2.setName("Dengoso");
        animal2.setBreed("Vira lata");
        animalList.add(animal2);

        when(animalRepository.findAll()).thenReturn(animalList);

        List<Animal> result = animalService.listAll();

        Assertions.assertFalse(result.isEmpty());
        verify(animalRepository, times(1)).findAll();
    }

    @Test
    void testFindAnimalById() {
        Long animalId = 1L;
        Animal animal = new Animal();
        animal.setName("Amarelão");
        animal.setBreed("Vira lata");

        when(animalRepository.findById(anyLong())).thenReturn(Optional.of(animal));

        Animal result = animalService.findById(animalId);

        Assertions.assertNotNull(result);
        verify(animalRepository, times(1)).findById(animalId);
    }

    @Test
    void testFindAnimalByIdCaregiver() {
        Long caregiverId = 1L;
        List<Animal> animalList = new ArrayList<>();
        Animal animal1 = new Animal();
        animal1.setName("Amarelão");
        animal1.setBreed("Vira lara");
        animalList.add(animal1);

        Animal animal2 = new Animal();
        animal2.setName("Belinha");
        animal2.setBreed("Golden Retriever");
        animalList.add(animal2);

        when(animalRepository.findAnimalByIdCaregiver(anyLong())).thenReturn(animalList);

        List<Animal> result = animalService.findAnimalByIdCaregiver(caregiverId);

        Assertions.assertFalse(result.isEmpty());
        verify(animalRepository, times(1)).findAnimalByIdCaregiver(caregiverId);
    }

    @Test
    void testUpdateAnimal() {
        Long animalId = 1L;
        Animal animal = new Animal();
        animal.setId(animalId);

        when(animalRepository.save(any(Animal.class))).thenReturn(animal);

        animalService.update(animal, animalId);

        verify(animalRepository, times(1)).save(any(Animal.class));
    }

    @Test
    void testDisableAnimal() {
        Long animalId = 1L;
        Animal animal = new Animal();
        animal.setId(animalId);

        when(animalRepository.findById(animalId)).thenReturn(Optional.of(animal));

        animalService.disable(animalId);

        verify(animalRepository, times(1)).disable(animalId);
    }
}
