package za.ac.cput.factory;

import za.ac.cput.domain.HomeAddress;
import za.ac.cput.util.Helper;

public class HomeAddressFactory {
    public static HomeAddress build(String streetNumber,
                                    String streetName,
                                    String suburb,
                                    String city,
                                    String province,
                                    String country,
                                    int postalCode) {
        // Validate required fields
        if (Helper.isNullOrEmpty(streetNumber)) {
            throw new IllegalArgumentException("Street number is required");
        }
        if (Helper.isNullOrEmpty(streetName)) {
            throw new IllegalArgumentException("Street name is required");
        }
        if (Helper.isNullOrEmpty(city)) {
            throw new IllegalArgumentException("City is required");
        }
        if (Helper.isNullOrEmpty(province)) {
            throw new IllegalArgumentException("Province is required");
        }
        if (Helper.isNullOrEmpty(country)) {
            throw new IllegalArgumentException("Country is required");
        }

        // Validate postal code
        if (postalCode < 1000 || postalCode > 9999) {
            throw new IllegalArgumentException("Postal code must be between 1000 and 9999");
        }

        // Suburb can be null or empty, so no validation needed

        return new HomeAddress.Builder()
                .setStreetNumber(streetNumber.trim())
                .setStreetName(streetName.trim())
                .setSuburb(Helper.isNullOrEmpty(suburb) ? null : suburb.trim())
                .setCity(city.trim())
                .setProvince(province.trim())
                .setCountry(country.trim())
                .setPostalCode(postalCode)
                .build();
        
    }
}