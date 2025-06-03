package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Customer;

import java.util.List;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, String> {
    Customer findByEmail(String email);

    List<Customer> findByLastName(String lastName);
}
