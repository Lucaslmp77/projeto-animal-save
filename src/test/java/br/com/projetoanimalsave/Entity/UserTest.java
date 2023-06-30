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
    public void testGetRoles() {
        User user = new User();
        Role role = new Role("ROLE_ADMIN");
        user.addRole(role);

        Set<Role> roles = user.getRoles();

        Assertions.assertEquals(1, roles.size());
        Assertions.assertTrue(roles.contains(role));
    }

    @Test
    public void testSetRoles() {
        User user = new User();
        Set<Role> roles = new HashSet<>();
        Role role = new Role("ROLE_ADMIN");
        roles.add(role);

        user.setRoles(roles);

        Assertions.assertEquals(1, user.getRoles().size());
        Assertions.assertTrue(user.hasRole("ROLE_ADMIN"));
    }

    @Test
    public void testAddRole() {
        User user = new User();
        Role role = new Role("ROLE_ADMIN");

        user.addRole(role);

        Assertions.assertEquals(1, user.getRoles().size());
        Assertions.assertTrue(user.getRoles().contains(role));
    }

    @Test
    public void testHasRole() {
        User user = new User();
        Role role = new Role("ROLE_ADMIN");
        user.addRole(role);

        Assertions.assertTrue(user.hasRole("ROLE_ADMIN"));
        Assertions.assertFalse(user.hasRole("ROLE_USER"));
    }

    @Test
    public void testGetAuthorities() {
        User user = new User();
        Role role = new Role("ROLE_ADMIN");
        user.addRole(role);

        Collection<? extends GrantedAuthority> authorities = user.getAuthorities();

        Assertions.assertEquals(1, authorities.size());
        Assertions.assertTrue(authorities.contains(role));
    }

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
