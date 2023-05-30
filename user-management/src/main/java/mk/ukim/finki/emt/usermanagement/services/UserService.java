package mk.ukim.finki.emt.usermanagement.services;

import mk.ukim.finki.emt.usermanagement.domain.models.AbstractUser;
import mk.ukim.finki.emt.usermanagement.domain.models.User;
import mk.ukim.finki.emt.usermanagement.domain.models.UserId;

import java.util.List;

public interface UserService {

    AbstractUser findById(UserId userId);
    AbstractUser findByUsername(String username);
    List<AbstractUser> findAll();
    void deleteById(UserId userId);
}
