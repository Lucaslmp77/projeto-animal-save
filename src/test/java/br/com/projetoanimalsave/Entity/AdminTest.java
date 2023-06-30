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
    public void naoDeveRetornarNomeDoAdminMenorQue3Letras() {
        Admin admin = new Admin();

        Assertions.assertThrows(RuntimeException.class, () -> admin.setName("RF"));
    }

    @Test
    public void naoDeveRetornarNomeDoAdminMaiorQue25Letras() {
        Admin admin = new Admin();

        Assertions.assertThrows(RuntimeException.class, () -> admin.setName("Rodrigo Ferreira Silvio Valerio Da Silva"));
    }

    @Test
    public void naoDeveCadastrarAdminComNomeCompostoPorNumeros() {
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
