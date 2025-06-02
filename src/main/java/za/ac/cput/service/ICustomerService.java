package za.ac.cput.service;

import za.ac.cput.domain.Customer;
import java.util.List;
import java.util.Set;

public interface ICustomerService extends IService<Customer, String> {
    Set<Customer> getAll();

    Customer findByEmail(String email);

    List<Customer> findByLastName(String lastName);
}
