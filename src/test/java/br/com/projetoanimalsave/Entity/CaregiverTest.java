package br.com.projetoanimalsave.Entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class CaregiverTest {

    @Test
    public void testGetFirstName() {
        String firstName = "Lucas";
        Caregiver caregiver = new Caregiver();
        caregiver.setFirstName(firstName);

        Assertions.assertEquals(firstName, caregiver.getFirstName());
    }

    @Test
    public void testGetLastName() {
        String lastName = "Mendes";
        Caregiver caregiver = new Caregiver();
        caregiver.setLastName(lastName);

        Assertions.assertEquals(lastName, caregiver.getLastName());
    }

    @Test
    public void testGetContact() {
        String contact = "00 0 00000000";
        Caregiver caregiver = new Caregiver();
        caregiver.setContact(contact);

        Assertions.assertEquals(contact, caregiver.getContact());
    }

    @Test
    public void testGetCpf() {
        String cpf = "12345678900";
        Caregiver caregiver = new Caregiver();
        caregiver.setCpf(cpf);

        Assertions.assertEquals(cpf, caregiver.getCpf());
    }

    @Test
    public void testGetSetAddress() {
        Address address = new Address();
        Caregiver caregiver = new Caregiver();
        caregiver.setAddress(address);

        Assertions.assertEquals(address, caregiver.getAddress());
    }

    @Test
    public void testGetPhysicalSpace() {
        String physicalSpace = "500 metros";
        Caregiver caregiver = new Caregiver();
        caregiver.setPhysicalSpace(physicalSpace);

        Assertions.assertEquals(physicalSpace, caregiver.getPhysicalSpace());
    }

    @Test
    public void testGetSpending() {
        String spending = "2.000,00";
        Caregiver caregiver = new Caregiver();
        caregiver.setSpending(spending);

        Assertions.assertEquals(spending, caregiver.getSpending());
    }

    @Test
    public void testGetCapacityAnimals() {
        Double capacityAnimals = 10.0;
        Caregiver caregiver = new Caregiver();
        caregiver.setCapacityAnimals(capacityAnimals);

        Assertions.assertEquals(capacityAnimals, caregiver.getCapacityAnimals());
    }

    @Test
    public void testGetSetOccurrence() {
        List<Occurrence> occurrences = new ArrayList<>();
        Caregiver caregiver = new Caregiver();
        caregiver.setOccurrence(occurrences);

        Assertions.assertEquals(occurrences, caregiver.getOccurrence());
    }

    @Test
    public void testGetSetUser() {
        User user = new User();
        Caregiver caregiver = new Caregiver();
        caregiver.setUser(user);

        Assertions.assertEquals(user, caregiver.getUser());
    }
}
