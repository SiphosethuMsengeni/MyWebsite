package za.ac.cput.domain;

import java.util.Objects;

public class Customer {
    private String customerId;
    private String firstName;
    private String lastName;
    private String email;
    private String mobile;
    private long address;

    private Customer(Builder builder) {
        this.customerId = builder.customerId;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.email = builder.email;
        this.mobile = builder.mobile;
        this.address = builder.address;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getMobile() {
        return mobile;
    }

    public long getAddress() {
        return address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(customerId, customer.customerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId='" + customerId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public static class Builder {
        private String customerId;
        private String firstName;
        private String lastName;
        private String email;
        private String mobile;
        private long address;

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }
        public void setLastName(String lastName) {
            this.lastName = lastName;
        }
        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }
        public void setEmail(String email) {
            this.email = email;
        }
        public void setMobile(String mobile) {
            this.mobile = mobile;
        }
    }

}
