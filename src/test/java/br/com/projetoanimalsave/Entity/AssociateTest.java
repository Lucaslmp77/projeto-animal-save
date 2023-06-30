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
    public void testGetLastName() {
        String lastName = "Mendes";
        Associate associate = new Associate();
        associate.setLastName(lastName);

        Assertions.assertEquals(lastName, associate.getLastName());
    }

    @Test
    public void testGetContact() {
        String contact = "00 0 00000000";
        Associate associate = new Associate();
        associate.setContact(contact);

        Assertions.assertEquals(contact, associate.getContact());
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
