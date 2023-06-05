package br.com.projetoanimalsave.Service;

import br.com.projetoanimalsave.Entity.Address;
import br.com.projetoanimalsave.Repository.AddressRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {
    @Autowired
    private AddressRepository addressRepository;

    @Transactional
    public Address save(Address address) {
        return this.addressRepository.save(address);
    }

    public List<Address> listAll() {
        return this.addressRepository.findAll();
    }

    public Address findById(Long id) {
        return this.addressRepository.findById(id).orElse(new Address());
    }

    @Transactional
    public void update(Address address, Long id) {
        if (id == address.getId()) {
            this.addressRepository.save(address);
        } else {
            throw new RuntimeException();
        }
    }
}
