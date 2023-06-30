package br.com.projetoanimalsave.Entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class RoleTest {
    @Test
    public void testGettersAndSetters() {
        Role role = new Role();
        role.setId(1L);
        role.setAuthority("ROLE_ADMIN");

        Assertions.assertEquals(1L, role.getId());
        Assertions.assertEquals("ROLE_ADMIN", role.getAuthority());
    }

}
