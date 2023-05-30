package mk.ukim.finki.emt.ordermanagement.domain.valueObjects;

import lombok.Getter;
import mk.ukim.finki.emt.sharedkernel.domain.base.ValueObject;

@Getter
public class Address implements ValueObject {

    private final String streetAddress;

    private final Integer houseNumber;

    private final Integer postalCode;

    private final String city;

    private final String country;

    public Address(String streetAddress, Integer houseNumber, Integer postalCode, String city, String country) {
        this.streetAddress = streetAddress;
        this.houseNumber = houseNumber;
        this.postalCode = postalCode;
        this.city = city;
        this.country = country;
    }
}
