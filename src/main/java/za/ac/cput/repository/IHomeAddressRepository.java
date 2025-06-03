package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.HomeAddress;

import java.util.List;

@Repository
public interface IHomeAddressRepository extends JpaRepository<HomeAddress, Long> {
    List<HomeAddress> findByCity(String city);
    List<HomeAddress> findByProvince(String province);
}