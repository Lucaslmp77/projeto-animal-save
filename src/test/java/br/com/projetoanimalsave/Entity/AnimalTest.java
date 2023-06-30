package br.com.projetoanimalsave.Entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AnimalTest {

    @Test
    public void testGetName() {
        String name = "Caramelo";
        Animal animal = new Animal();
        animal.setName(name);

        Assertions.assertEquals(name, animal.getName());
    }

    @Test
    public void testGetBreed() {
        String breed = "Vira lata";
        Animal animal = new Animal();
        animal.setBreed(breed);

        Assertions.assertEquals(breed, animal.getBreed());
    }

    @Test
    public void testGetVaccination() {
        Vaccination vaccination = new Vaccination();
        Animal animal = new Animal();
        animal.setVaccination(vaccination);

        Assertions.assertEquals(vaccination, animal.getVaccination());
    }

    @Test
    public void testGetAnimalType() {
        AnimalType animalType = AnimalType.CACHORRO;
        Animal animal = new Animal();
        animal.setAnimalType(animalType);

        Assertions.assertEquals(animalType, animal.getAnimalType());
    }

    @Test
    public void testGetAnimalSize() {
        AnimalSize animalSize = AnimalSize.MEDIO;
        Animal animal = new Animal();
        animal.setAnimalSize(animalSize);

        Assertions.assertEquals(animalSize, animal.getAnimalSize());
    }

    @Test
    public void testGetColor() {
        String color = "Caramelo";
        Animal animal = new Animal();
        animal.setColor(color);

        Assertions.assertEquals(color, animal.getColor());
    }

    @Test
    public void testGetAge() {
        Integer age = 3;
        Animal animal = new Animal();
        animal.setAge(age);

        Assertions.assertEquals(age, animal.getAge());
    }

    @Test
    public void testGetObservation() {
        String observation = "Bolado demais";
        Animal animal = new Animal();
        animal.setObservation(observation);

        Assertions.assertEquals(observation, animal.getObservation());
    }

    @Test
    public void testGetCaregiver() {
        Caregiver caregiver = new Caregiver();
        Animal animal = new Animal();
        animal.setCaregiver(caregiver);

        Assertions.assertEquals(caregiver, animal.getCaregiver());
    }
}
