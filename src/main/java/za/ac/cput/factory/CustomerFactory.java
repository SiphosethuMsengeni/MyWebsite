package za.ac.cput.factory;

import za.ac.cput.domain.Customer;

public class CustomerFactory {
    public static Customer createCustomer(String customerId, String firstName, String lastName, String email, String mobile, long address) {
        if (customerId == null || customerId.isEmpty())
            throw new IllegalArgumentException("Customer ID is required");
        if (firstName == null || firstName.isEmpty())
            throw new IllegalArgumentException("First name is required");
        if (lastName == null || lastName.isEmpty())
            throw new IllegalArgumentException("Last name is required");
        if (email == null || !isValidEmail(email))
            throw new IllegalArgumentException("Valid email is required");
        if (mobile == null || !isValidMobile(mobile))
            throw new IllegalArgumentException("Valid mobile is required");

        return new Customer.Builder()
                .setCustomerId(customerId)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setMobile(mobile)
                .setAddress(address)
                .build();
    }

    private static boolean isValidEmail(String email) {
        return email.matches("^[A-Za-z0-9+_.-]+@(.+)$");
    }

    private static boolean isValidMobile(String mobile) {
        return mobile.matches("^\\d{10}$");
    }
}
