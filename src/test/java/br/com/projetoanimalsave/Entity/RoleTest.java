package br.com.projetoanimalsave.Entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class RoleTest {

    @Test
    public void testEquals() {
        Role role1 = new Role("ROLE_ADMIN");
        Role role2 = new Role("ROLE_ADMIN");
        Role role3 = new Role("ROLE_USER");

        // Testar igualdade entre dois objetos Role com a mesma autoridade
        Assertions.assertEquals(role1, role2);

        // Testar desigualdade entre dois objetos Role com autoridades diferentes
        Assertions.assertNotEquals(role1, role3);
    }

    @Test
    public void testHashCode() {
        Role role1 = new Role("ROLE_ADMIN");
        Role role2 = new Role("ROLE_ADMIN");
        Role role3 = new Role("ROLE_USER");

        // Testar igualdade dos hashes de dois objetos Role com a mesma autoridade
        Assertions.assertEquals(role1.hashCode(), role2.hashCode());

        // Testar desigualdade dos hashes de dois objetos Role com autoridades diferentes
        Assertions.assertNotEquals(role1.hashCode(), role3.hashCode());
    }

    @Test
    public void testGettersAndSetters() {
        Role role = new Role();
        role.setId(1L);
        role.setAuthority("ROLE_ADMIN");

        Assertions.assertEquals(1L, role.getId());
        Assertions.assertEquals("ROLE_ADMIN", role.getAuthority());
    }

    @Test
    public void testGetUser() {
        Role role = new Role();
        List<User> users = new ArrayList<>();
        User user1 = new User();
        User user2 = new User();
        users.add(user1);
        users.add(user2);
        role.setUser(users);

        Assertions.assertEquals(users, role.getUser());
    }
}
