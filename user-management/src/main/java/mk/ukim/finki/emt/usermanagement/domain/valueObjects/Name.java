package mk.ukim.finki.emt.usermanagement.domain.valueObjects;

import lombok.Getter;

@Getter
public class Name {

    private final String firstName;

    private final String middleName;

    private final String lastName;

    public Name(String firstName, String middleName, String lastName) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    }
}
