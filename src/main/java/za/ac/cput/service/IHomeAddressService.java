
package za.ac.cput.service;

import za.ac.cput.domain.HomeAddress;
import java.util.List;
import java.util.Optional;

public interface IHomeAddressService {
    HomeAddress save(HomeAddress homeAddress);
    Optional<HomeAddress> findById(Long id);
    List<HomeAddress> findAll();
    void deleteById(Long id);
    boolean existsById(Long id);
    HomeAddress update(HomeAddress homeAddress);
    List<HomeAddress> findByCity(String city);
    List<HomeAddress> findByProvince(String province);
}