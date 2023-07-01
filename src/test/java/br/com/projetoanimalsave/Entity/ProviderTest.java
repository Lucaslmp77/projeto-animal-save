package br.com.projetoanimalsave.Entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProviderTest {

    @Test
    public void testGetFantasyName() {
        String fantasyName = "A.S Fantasia";
        Provider provider = new Provider();
        provider.setFantasyName(fantasyName);

        Assertions.assertEquals(fantasyName, provider.getFantasyName());
    }

    @Test
    public void testSetFantasyName_NullFantasyName() {
        Provider provider = new Provider();

        Assertions.assertThrows(RuntimeException.class, () -> {
            provider.setFantasyName(null);
        });
    }

    @Test
    public void testSetFantasyName_EmptyFantasyName() {
        Provider provider = new Provider();

        Assertions.assertThrows(RuntimeException.class, () -> {
            provider.setFantasyName("");
        });
    }

    @Test
    public void testSetFantasyName_ShortFantasyName() {
        Provider provider = new Provider();

        Assertions.assertThrows(RuntimeException.class, () -> {
            provider.setFantasyName("AB");
        });
    }

    @Test
    public void testSetFantasyName_LongFantasyName() {
        Provider provider = new Provider();

        Assertions.assertThrows(RuntimeException.class, () -> {
            provider.setFantasyName("Este é um nome fantasia muito longo que excede o limite máximo");
        });
    }

    @Test
    public void testSetFantasyName_FantasyNameWithNumbers() {
        Provider provider = new Provider();

        Assertions.assertThrows(RuntimeException.class, () -> {
            provider.setFantasyName("12345");
        });
    }

    @Test
    public void testGetBusinessName() {
        String businessName = "Animal S. Empresarial";
        Provider provider = new Provider();
        provider.setBusinessName(businessName);

        Assertions.assertEquals(businessName, provider.getBusinessName());
    }

    @Test
    public void testSetBusinessName_NullBusinessName() {
        Provider provider = new Provider();

        Assertions.assertThrows(RuntimeException.class, () -> {
            provider.setBusinessName(null);
        });
    }

    @Test
    public void testSetBusinessName_EmptyBusinessName() {
        Provider provider = new Provider();

        Assertions.assertThrows(RuntimeException.class, () -> {
            provider.setBusinessName("");
        });
    }

    @Test
    public void testSetBusinessName_ShortBusinessName() {
        Provider provider = new Provider();

        Assertions.assertThrows(RuntimeException.class, () -> {
            provider.setBusinessName("AB");
        });
    }

    @Test
    public void testSetBusinessName_LongBusinessName() {
        Provider provider = new Provider();

        Assertions.assertThrows(RuntimeException.class, () -> {
            provider.setBusinessName("Este é um nome empresarial muito longo que excede o limite máximo permitido pelo sistema");
        });
    }

    @Test
    public void testSetBusinessName_BusinessNameWithNumbers() {
        Provider provider = new Provider();

        Assertions.assertThrows(RuntimeException.class, () -> {
            provider.setBusinessName("12345");
        });
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
    public void testSetContact_NullContact() {
        Provider provider = new Provider();

        Assertions.assertThrows(RuntimeException.class, () -> {
            provider.setContact(null);
        });
    }

    @Test
    public void testSetContact_EmptyContact() {
        Provider provider = new Provider();

        Assertions.assertThrows(RuntimeException.class, () -> {
            provider.setContact("");
        });
    }

    @Test
    public void testSetContact_ShortContact() {
        Provider provider = new Provider();

        Assertions.assertThrows(RuntimeException.class, () -> {
            provider.setContact("123");
        });
    }

    @Test
    public void testSetContact_LongContact() {
        Provider provider = new Provider();

        Assertions.assertThrows(RuntimeException.class, () -> {
            provider.setContact("Este é um contato muito longo que ultrapassa o limite máximo permitido");
        });
    }

    @Test
    public void testGetSetAddress() {
        Address address = new Address();
        Provider provider = new Provider();
        provider.setAddress(address);

        Assertions.assertEquals(address, provider.getAddress());
    }

    @Test
    public void testGetSetUser() {
        User user = new User();
        Provider provider = new Provider();
        provider.setUser(user);

        Assertions.assertEquals(user, provider.getUser());
    }
}
