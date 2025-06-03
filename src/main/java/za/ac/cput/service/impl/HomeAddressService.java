package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.HomeAddress;
import za.ac.cput.repository.IHomeAddressRepository;
import za.ac.cput.service.IHomeAddressService;

import java.util.List;
import java.util.Optional;

@Service
public class HomeAddressService implements IHomeAddressService {
    private final IHomeAddressRepository repository;

    @Autowired
    public HomeAddressService(IHomeAddressRepository repository) {
        this.repository = repository;
    }

    @Override
    public HomeAddress save(HomeAddress homeAddress) {
        return repository.save(homeAddress);
    }

    @Override
    public Optional<HomeAddress> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<HomeAddress> findAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return repository.existsById(id);
    }

    @Override
    public HomeAddress update(HomeAddress homeAddress) {
        if (homeAddress.getAddressId() == null || !repository.existsById(homeAddress.getAddressId())) {
            throw new IllegalArgumentException("Cannot update non-existent address");
        }
        return repository.save(homeAddress);
    }

    @Override
    public List<HomeAddress> findByCity(String city) {
        return repository.findByCity(city);
    }

    @Override
    public List<HomeAddress> findByProvince(String province) {
        return repository.findByProvince(province);
    }
}