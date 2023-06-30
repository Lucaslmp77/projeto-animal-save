package br.com.projetoanimalsave.Entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AssociateTest {

    @Test
    public void testGetFirstName() {
        String firstName = "Lucas";
        Associate associate = new Associate();
        associate.setFirstName(firstName);

        Assertions.assertEquals(firstName, associate.getFirstName());
    }

    @Test
    public void testSetFirstName_NullFirstName() {
        Associate associate = new Associate();

        Assertions.assertThrows(RuntimeException.class, () -> associate.setFirstName(null));
    }

    @Test
    public void testSetFirstName_EmptyFirstName() {
        Associate associate = new Associate();

        Assertions.assertThrows(RuntimeException.class, () -> associate.setFirstName(""));
    }

    @Test
    public void testSetFirstName_ShortFirstName() {
        Associate associate = new Associate();

        Assertions.assertThrows(RuntimeException.class, () -> associate.setFirstName("Jo"));
    }

    @Test
    public void testSetFirstName_LongFirstName() {
        Associate associate = new Associate();

        Assertions.assertThrows(RuntimeException.class, () -> associate.setFirstName("LoremIpsumDolorSitAmetConsectetur"));
    }

    @Test
    public void testSetFirstName_NumericFirstName() {
        Associate associate = new Associate();

        Assertions.assertThrows(RuntimeException.class, () -> associate.setFirstName("123"));
    }

    @Test
    public void testGetLastName() {
        String lastName = "Mendes";
        Associate associate = new Associate();
        associate.setLastName(lastName);

        Assertions.assertEquals(lastName, associate.getLastName());
    }

    @Test
    public void testSetLastName_NullLastName() {
        Associate associate = new Associate();

        Assertions.assertThrows(RuntimeException.class, () -> associate.setLastName(null));
    }

    @Test
    public void testSetLastName_EmptyLastName() {
        Associate associate = new Associate();

        Assertions.assertThrows(RuntimeException.class, () -> associate.setLastName(""));
    }

    @Test
    public void testSetLastName_ShortLastName() {
        Associate associate = new Associate();

        Assertions.assertThrows(RuntimeException.class, () -> associate.setLastName("D"));
    }

    @Test
    public void testSetLastName_LongLastName() {
        Associate associate = new Associate();

        Assertions.assertThrows(RuntimeException.class, () -> associate.setLastName("LoremIpsumDolorSitAmetConsecteturLoremIpsumDolorSitAmetConsectetur"));
    }

    @Test
    public void testSetLastName_NumericLastName() {
        Associate associate = new Associate();

        Assertions.assertThrows(RuntimeException.class, () -> associate.setLastName("123"));
    }

    @Test
    public void testGetContact() {
        String contact = "00 0 00000000";
        Associate associate = new Associate();
        associate.setContact(contact);

        Assertions.assertEquals(contact, associate.getContact());
    }

    @Test
    public void testSetContact_NullContact() {
        Associate associate = new Associate();

        Assertions.assertThrows(RuntimeException.class, () -> associate.setContact(null));
    }

    @Test
    public void testSetContact_EmptyContact() {
        Associate associate = new Associate();

        Assertions.assertThrows(RuntimeException.class, () -> associate.setContact(""));
    }

    @Test
    public void testSetContact_ShortContact() {
        Associate associate = new Associate();

        Assertions.assertThrows(RuntimeException.class, () -> associate.setContact("1234"));
    }

    @Test
    public void testSetContact_LongContact() {
        Associate associate = new Associate();

        Assertions.assertThrows(RuntimeException.class, () -> associate.setContact("12345678901234567890123456"));
    }

    @Test
    public void testGetCpf() {
        String cpf = "12345678900";
        Associate associate = new Associate();
        associate.setCpf(cpf);

        Assertions.assertEquals(cpf, associate.getCpf());
    }

    @Test
    public void testGetSetAddress() {
        Address address = new Address();
        Associate associate = new Associate();
        associate.setAddress(address);

        Assertions.assertEquals(address, associate.getAddress());
    }

    @Test
    public void testGetSetUser() {
        User user = new User();
        Associate associate = new Associate();
        associate.setUser(user);

        Assertions.assertEquals(user, associate.getUser());
    }
}
