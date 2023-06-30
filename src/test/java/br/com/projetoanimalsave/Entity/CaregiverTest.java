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
    public void testSetFirstName_NullFirstName() {
        Caregiver caregiver = new Caregiver();

        Assertions.assertThrows(RuntimeException.class, () -> caregiver.setFirstName(null));
    }

    @Test
    public void testSetFirstName_EmptyFirstName() {
        Caregiver caregiver = new Caregiver();

        Assertions.assertThrows(RuntimeException.class, () -> caregiver.setFirstName(""));
    }

    @Test
    public void testSetFirstName_ShortFirstName() {
        Caregiver caregiver = new Caregiver();

        Assertions.assertThrows(RuntimeException.class, () -> caregiver.setFirstName("Jo"));
    }

    @Test
    public void testSetFirstName_LongFirstName() {
        Caregiver caregiver = new Caregiver();

        Assertions.assertThrows(RuntimeException.class, () -> caregiver.setFirstName("JohnJohnJohnJohnJohnJohnJohnJohnJohnJohn"));
    }

    @Test
    public void testSetFirstName_NumericFirstName() {
        Caregiver caregiver = new Caregiver();

        Assertions.assertThrows(RuntimeException.class, () -> caregiver.setFirstName("123"));
    }

    @Test
    public void testGetLastName() {
        String lastName = "Mendes";
        Caregiver caregiver = new Caregiver();
        caregiver.setLastName(lastName);

        Assertions.assertEquals(lastName, caregiver.getLastName());
    }

    @Test
    public void testSetLastName_NullLastName() {
        Caregiver caregiver = new Caregiver();

        Assertions.assertThrows(RuntimeException.class, () -> caregiver.setLastName(null));
    }

    @Test
    public void testSetLastName_EmptyLastName() {
        Caregiver caregiver = new Caregiver();

        Assertions.assertThrows(RuntimeException.class, () -> caregiver.setLastName(""));
    }

    @Test
    public void testSetLastName_ShortLastName() {
        Caregiver caregiver = new Caregiver();

        Assertions.assertThrows(RuntimeException.class, () -> caregiver.setLastName("D"));
    }

    @Test
    public void testSetLastName_LongLastName() {
        Caregiver caregiver = new Caregiver();

        Assertions.assertThrows(RuntimeException.class, () -> caregiver.setLastName("DoeDoeDoeDoeDoeDoeDoeDoeDoeDoeDoeDoeDoeDoeDoeDoeDoeDoeDoeDoeDoeDoeDoe"));
    }

    @Test
    public void testSetLastName_NumericLastName() {
        Caregiver caregiver = new Caregiver();

        Assertions.assertThrows(RuntimeException.class, () -> caregiver.setLastName("123"));
    }

    @Test
    public void testGetContact() {
        String contact = "00 0 00000000";
        Caregiver caregiver = new Caregiver();
        caregiver.setContact(contact);

        Assertions.assertEquals(contact, caregiver.getContact());
    }

    @Test
    public void testSetContact_NullContact() {
        Caregiver caregiver = new Caregiver();

        Assertions.assertThrows(RuntimeException.class, () -> caregiver.setContact(null));
    }

    @Test
    public void testSetContact_EmptyContact() {
        Caregiver caregiver = new Caregiver();

        Assertions.assertThrows(RuntimeException.class, () -> caregiver.setContact(""));
    }

    @Test
    public void testSetContact_ShortContact() {
        Caregiver caregiver = new Caregiver();

        Assertions.assertThrows(RuntimeException.class, () -> caregiver.setContact("1234"));
    }

    @Test
    public void testSetContact_LongContact() {
        Caregiver caregiver = new Caregiver();

        Assertions.assertThrows(RuntimeException.class, () -> caregiver.setContact("12345678901234567890123456"));
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
    public void testSetPhysicalSpace_NullPhysicalSpace() {
        Caregiver caregiver = new Caregiver();

        Assertions.assertThrows(RuntimeException.class, () -> caregiver.setPhysicalSpace(null));
    }

    @Test
    public void testSetPhysicalSpace_EmptyPhysicalSpace() {
        Caregiver caregiver = new Caregiver();

        Assertions.assertThrows(RuntimeException.class, () -> caregiver.setPhysicalSpace(""));
    }

    @Test
    public void testSetPhysicalSpace_ShortPhysicalSpace() {
        Caregiver caregiver = new Caregiver();

        Assertions.assertThrows(RuntimeException.class, () -> caregiver.setPhysicalSpace("Ab"));
    }

    @Test
    public void testSetPhysicalSpace_LongPhysicalSpace() {
        Caregiver caregiver = new Caregiver();

        Assertions.assertThrows(RuntimeException.class, () -> caregiver.setPhysicalSpace("Espaço físico com nome muito longo que ultrapassa o limite permitido"));
    }

    @Test
    public void testGetSpending() {
        String spending = "2.000,00";
        Caregiver caregiver = new Caregiver();
        caregiver.setSpending(spending);

        Assertions.assertEquals(spending, caregiver.getSpending());
    }

    @Test
    public void testSetSpending_NullSpending() {
        Caregiver caregiver = new Caregiver();

        Assertions.assertThrows(RuntimeException.class, () -> caregiver.setSpending(null));
    }

    @Test
    public void testSetSpending_EmptySpending() {
        Caregiver caregiver = new Caregiver();

        Assertions.assertThrows(RuntimeException.class, () -> caregiver.setSpending(""));
    }

    @Test
    public void testSetSpending_ShortSpending() {
        Caregiver caregiver = new Caregiver();

        Assertions.assertThrows(RuntimeException.class, () -> caregiver.setSpending("3"));
    }

    @Test
    public void testSetSpending_LongSpending() {
        Caregiver caregiver = new Caregiver();

        Assertions.assertThrows(RuntimeException.class, () -> caregiver.setSpending("Gastos do protetor com um valor muito longo que ultrapassa o limite permitido"));
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
