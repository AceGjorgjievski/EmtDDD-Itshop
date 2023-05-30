package mk.ukim.finki.emt.usermanagement.domain.models;

import javax.persistence.*;

import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.emt.usermanagement.domain.enums.Role;
import mk.ukim.finki.emt.usermanagement.domain.valueObjects.Name;

@Entity
@Table(name="abstract_user")
public class AbstractUser extends AbstractEntity<UserId> {

    @Enumerated(EnumType.STRING)
    private Role userRole;

    private Name name;

    private String username;

    private String emailAddress;

    private String password;
}
