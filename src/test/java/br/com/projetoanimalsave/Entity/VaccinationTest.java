package br.com.projetoanimalsave.Entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class VaccinationTest {

    @Test
    public void testGetRabies() {
        Boolean rabies = true;
        Vaccination vaccination = new Vaccination();
        vaccination.setRabies(rabies);

        Assertions.assertEquals(rabies, vaccination.getRabies());
    }

    @Test
    public void testGetCanineParvovirus() {
        Boolean canineParvovirus = true;
        Vaccination vaccination = new Vaccination();
        vaccination.setCanineParvovirus(canineParvovirus);

        Assertions.assertEquals(canineParvovirus, vaccination.getCanineParvovirus());
    }

    @Test
    public void testGetDistemper() {
        Boolean distemper = true;
        Vaccination vaccination = new Vaccination();
        vaccination.setDistemper(distemper);

        Assertions.assertEquals(distemper, vaccination.getDistemper());
    }

    @Test
    public void testGetCanineHepatitis() {
        Boolean canineHepatitis = true;
        Vaccination vaccination = new Vaccination();
        vaccination.setCanineHepatitis(canineHepatitis);

        Assertions.assertEquals(canineHepatitis, vaccination.getCanineHepatitis());
    }

    @Test
    public void testGetAnimal() {
        Animal animal = new Animal();
        Vaccination vaccination = new Vaccination();
        vaccination.setAnimal(animal);

        Assertions.assertEquals(animal, vaccination.getAnimal());
    }
}
