package br.com.projetoanimalsave.Service;

import br.com.projetoanimalsave.Repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    private BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        return userRepository.findByLogin(username);
    }

    @Transactional
    public void newPassword(String password, Long id) {
        var user = this.userRepository.findById(id);
        if (id == user.get().getId()){
            this.userRepository.newPassword(passwordEncoder().encode(password), id);
        } else {
            throw new RuntimeException();
        }
    }
}
