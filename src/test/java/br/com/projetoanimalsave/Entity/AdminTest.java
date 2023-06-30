package br.com.projetoanimalsave.Entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AdminTest {

    @Test
    public void testGetName() {
        String name = "Lucas";
        Admin admin = new Admin();
        admin.setName(name);

        Assertions.assertEquals(name, admin.getName());
    }

    @Test
    public void testSetAdm_NullAdm() {
        Admin admin = new Admin();

        Assertions.assertThrows(RuntimeException.class, () -> admin.setName(null));
    }

    @Test
    public void testSetAdm_EmptyAdm() {
        Admin admin = new Admin();

        Assertions.assertThrows(RuntimeException.class, () -> admin.setName(""));
    }

    @Test
    public void testSetAdm_ShortAdm() {
        Admin admin = new Admin();

        Assertions.assertThrows(RuntimeException.class, () -> admin.setName("RF"));
    }

    @Test
    public void testSetAdm_LongAdm() {
        Admin admin = new Admin();

        Assertions.assertThrows(RuntimeException.class, () -> admin.setName("Rodrigo Ferreira Silvio Valerio Da Silva"));
    }

    @Test
    public void testSetAdm_NameCompostNumbers() {
        Admin admin = new Admin();

        Assertions.assertThrows(RuntimeException.class, () -> admin.setName("5353"));
    }

    @Test
    public void testGetSetUser() {
        User user = new User();
        Admin admin = new Admin();
        admin.setUser(user);

        Assertions.assertEquals(user, admin.getUser());
    }
}
