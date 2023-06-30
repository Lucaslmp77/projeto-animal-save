package br.com.projetoanimalsave.Entity;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@ExtendWith(SpringExtension.class)
public class UserTest {
    @Test
    public void testGetPassword() {
        User user = new User();
        String password = "password";
        user.setPassword(password);

        Assertions.assertEquals(password, user.getPassword());
    }

    @Test
    public void testGetUsername() {
        User user = new User();
        String username = "user123";
        user.setLogin(username);

        Assertions.assertEquals(username, user.getUsername());
    }

    @Test
    public void testIsAccountNonExpired() {
        User user = new User();

        Assertions.assertTrue(user.isAccountNonExpired());
    }

    @Test
    public void testIsAccountNonLocked() {
        User user = new User();

        Assertions.assertTrue(user.isAccountNonLocked());
    }

    @Test
    public void testIsCredentialsNonExpired() {
        User user = new User();

        Assertions.assertTrue(user.isCredentialsNonExpired());
    }

    @Test
    public void testIsEnabled() {
        User user = new User();

        Assertions.assertTrue(user.isEnabled());
    }
}
