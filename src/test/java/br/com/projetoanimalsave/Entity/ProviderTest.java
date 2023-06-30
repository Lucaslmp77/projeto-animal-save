package br.com.projetoanimalsave.Entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class ProviderTest {

    @Test
    public void testGetFantasyName() {
        String fantasyName = "A.S Fantasia";
        Provider provider = new Provider();
        provider.setFantasyName(fantasyName);

        Assertions.assertEquals(fantasyName, provider.getFantasyName());
    }

    @Test
    public void testGetBusinessName() {
        String businessName = "Animal S. Empresarial";
        Provider provider = new Provider();
        provider.setBusinessName(businessName);

        Assertions.assertEquals(businessName, provider.getBusinessName());
    }

    @Test
    public void testGetCnpj() {
        String cnpj = "12345678901234";
        Provider provider = new Provider();
        provider.setCnpj(cnpj);

        Assertions.assertEquals(cnpj, provider.getCnpj());
    }

    @Test
    public void testGetContact() {
        String contact = "00 0 00000000";
        Provider provider = new Provider();
        provider.setContact(contact);

        Assertions.assertEquals(contact, provider.getContact());
    }

    @Test
    public void testGetSetAddress() {
        Address address = new Address();
        Provider provider = new Provider();
        provider.setAddress(address);

        Assertions.assertEquals(address, provider.getAddress());
    }

    @Test
    public void testGetSetTasks() {
        Set<Task> tasks = new HashSet<>();
        Provider provider = new Provider();
        provider.setTasks(tasks);

        Assertions.assertEquals(tasks, provider.getTasks());
    }

    @Test
    public void testGetSetUser() {
        User user = new User();
        Provider provider = new Provider();
        provider.setUser(user);

        Assertions.assertEquals(user, provider.getUser());
    }
}
