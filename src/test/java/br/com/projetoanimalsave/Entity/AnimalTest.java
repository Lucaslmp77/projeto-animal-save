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
    public void testSetName_NullName() {
        Animal animal = new Animal();

        Assertions.assertThrows(RuntimeException.class, () -> animal.setName(null));
    }

    @Test
    public void testSetName_EmptyName() {
        Animal animal = new Animal();

        Assertions.assertThrows(RuntimeException.class, () -> animal.setName(""));
    }

    @Test
    public void testSetName_ShortName() {
        Animal animal = new Animal();

        Assertions.assertThrows(RuntimeException.class, () -> animal.setName("Bo"));
    }

    @Test
    public void testSetName_LongName() {
        Animal animal = new Animal();

        Assertions.assertThrows(RuntimeException.class, () -> animal.setName("Rodrigo Ferreira Silvio Valerio Da Silva"));
    }

    @Test
    public void testSetName_NameWithNumbers() {
        Animal animal = new Animal();

        Assertions.assertThrows(RuntimeException.class, () -> animal.setName("3232"));
    }

    @Test
    public void testGetBreed() {
        String breed = "Vira lata";
        Animal animal = new Animal();
        animal.setBreed(breed);

        Assertions.assertEquals(breed, animal.getBreed());
    }

    @Test
    public void testSetBreed_NullBreed() {
        Animal animal = new Animal();

        Assertions.assertThrows(RuntimeException.class, () -> animal.setBreed(null));
    }

    @Test
    public void testSetBreed_EmptyBreed() {
        Animal animal = new Animal();

        Assertions.assertThrows(RuntimeException.class, () -> animal.setBreed(""));
    }

    @Test
    public void testSetBreed_ShortBreed() {
        Animal animal = new Animal();

        Assertions.assertThrows(RuntimeException.class, () -> animal.setBreed("Ab"));
    }

    @Test
    public void testSetBreed_LongBreed() {
        Animal animal = new Animal();

        Assertions.assertThrows(RuntimeException.class, () -> animal.setBreed("BreedBreedBreedBreedBreedBreedBreed"));
    }

    @Test
    public void testSetBreed_BreedWithNumbers() {
        Animal animal = new Animal();

        Assertions.assertThrows(RuntimeException.class, () -> animal.setBreed("123"));
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
    public void testSetColor_NullColor() {
        Animal animal = new Animal();

        Assertions.assertThrows(RuntimeException.class, () -> animal.setColor(null));
    }

    @Test
    public void testSetColor_EmptyColor() {
        Animal animal = new Animal();

        Assertions.assertThrows(RuntimeException.class, () -> animal.setColor(""));
    }

    @Test
    public void testSetColor_ShortColor() {
        Animal animal = new Animal();

        Assertions.assertThrows(RuntimeException.class, () -> animal.setColor("R"));
    }

    @Test
    public void testSetColor_LongColor() {
        Animal animal = new Animal();

        Assertions.assertThrows(RuntimeException.class, () -> animal.setColor("ColorColorColorColorColorColorColorColor"));
    }

    @Test
    public void testSetColor_ColorWithNumbers() {
        Animal animal = new Animal();

        Assertions.assertThrows(RuntimeException.class, () -> animal.setColor("123"));
    }

    @Test
    public void testGetAge() {
        Integer age = 3;
        Animal animal = new Animal();
        animal.setAge(age);

        Assertions.assertEquals(age, animal.getAge());
    }

    @Test
    public void testSetAge_NullAge() {
        Animal animal = new Animal();

        Assertions.assertThrows(RuntimeException.class, () -> animal.setAge(null));
    }

    @Test
    public void testSetAge_NegativeAge() {
        Animal animal = new Animal();

        Assertions.assertThrows(RuntimeException.class, () -> animal.setAge(-1));
    }

    @Test
    public void testSetAge_LongAge() {
        Animal animal = new Animal();

        Assertions.assertThrows(RuntimeException.class, () -> animal.setAge(1000000001));
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
