package br.com.projetoanimalsave.Service;

import br.com.projetoanimalsave.Entity.Provider;
import br.com.projetoanimalsave.Repository.ProviderRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProviderService {
    @Autowired
    private ProviderRepository providerRepository;

    @Transactional
    public Provider save(Provider provider) {
        return this.providerRepository.save(provider);
    }

    public List<Provider> listAll() {
        return this.providerRepository.findAll();
    }

    public Provider findById(Long id) {
        return this.providerRepository.findById(id).orElse(new Provider());
    }

    @Transactional
    public void update(Provider provider, Long id){
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