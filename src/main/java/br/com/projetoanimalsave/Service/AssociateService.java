package br.com.projetoanimalsave.Service;

import br.com.projetoanimalsave.Entity.Associate;
import br.com.projetoanimalsave.Repository.AssociateRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssociateService {
    @Autowired
    private AssociateRepository associateRepository;

    @Transactional
    public Associate save(Associate associate) {
        return this.associateRepository.save(associate);
    }

    public List<Associate> listAll() {
        return this.associateRepository.findAll();
    }

    public Associate findById(Long id) {
        return this.associateRepository.findById(id).orElse(new Associate());
    }

    @Transactional
    public void update(Associate associate, Long id) {
        if (id == associate.getId()){
            this.associateRepository.save(associate);
        } else {
            throw new RuntimeException();
        }
    }

    @Transactional
    public void delete(Associate associate, Long id) {
        if (id == associate.getId()) {
            this.associateRepository.delete(associate);
        } else {
            throw new RuntimeException();
        }
    }
}
