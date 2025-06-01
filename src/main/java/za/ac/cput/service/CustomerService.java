package za.ac.cput.service;
import za.ac.cput.domain.Customer;

//import org. springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.HashSet;

//@Service
public class CustomerService implements IService<Customer, String> {
    private static CustomerService service = null;
    private static Set<Customer> customerDB = null;

    private CustomerService() {
        customerDB = new HashSet<Customer>();
    }

    public static CustomerService getService() {
        if (service == null) {
            service = new CustomerService();
        }
        return service;
    }

    @Override
    public Customer create(Customer customer) {
        customerDB.add(customer);
        return customer;
    }

    @Override
    public Customer read(String customerId) {
        return customerDB.stream()
                .filter(c -> c.getCustomerId().equals(customerId))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Customer update(Customer customer) {
        Customer existing = read(customer.getCustomerId());
        if (existing != null) {
            customerDB.remove(existing);
            customerDB.add(customer);
            return customer;
        }
        return null;
    }

    @Override
    public boolean delete(String customerId) {
        Customer customer = read(customerId);
        if (customer != null) {
            return customerDB.remove(customer);
        }
        return false;
    }

    public Set<Customer> getAll() {
        return customerDB;
    }

    public Customer findByEmail(String email) {
        return customerDB.stream()
                .filter(c -> c.getEmail().equals(email))
                .findFirst()
                .orElse(null);
    }

    public List<Customer> findByLastName(String lastName) {
        return customerDB.stream()
                .filter(c -> c.getLastName().equals(lastName))
                .toList();
    }
}
