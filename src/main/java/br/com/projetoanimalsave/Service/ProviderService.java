package br.com.projetoanimalsave.Service;

import br.com.projetoanimalsave.Entity.Provider;
import br.com.projetoanimalsave.Entity.Role;
import br.com.projetoanimalsave.Entity.User;
import br.com.projetoanimalsave.Repository.ProviderRepository;
import br.com.projetoanimalsave.Repository.RoleRepository;
import br.com.projetoanimalsave.Repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProviderService {
    @Autowired
    private ProviderRepository providerRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    private BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Transactional
    public Provider save(Provider provider) {
        User user = new User();
        user.setLogin(provider.getUser().getLogin());
        user.setPassword(passwordEncoder().encode(provider.getUser().getPassword()));
        Role providerRole = roleRepository.findByAuthority("ROLE_PROVIDER");
        user.getRoles().add(providerRole);
        this.userRepository.save(user);

        provider.setUser(user);
        provider.setPending(true);
        provider.setApproved(false);
        provider.setRejected(false);
        return this.providerRepository.save(provider);

    }

    public List<Provider> listAll() {
        return this.providerRepository.findAll();
    }

    public Provider findById(Long id) {
        return this.providerRepository.findById(id).orElse(new Provider());
    }

    @Transactional
    public void update(Provider provider, Long id) {
        if (id == provider.getId()) {
            this.providerRepository.save(provider);
        } else {
            throw new RuntimeException();
        }
    }

    @Transactional
    public void disable(Long id) {
        var provider = this.providerRepository.findById(id);
        if (id == provider.get().getId()) {
            this.providerRepository.disable(id);
        } else {
            throw new RuntimeException();
        }
    }
}