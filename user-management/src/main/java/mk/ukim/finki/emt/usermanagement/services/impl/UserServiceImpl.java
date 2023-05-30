package mk.ukim.finki.emt.usermanagement.services.impl;

import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.usermanagement.domain.exceptions.UserIdNotFoundException;
import mk.ukim.finki.emt.usermanagement.domain.models.AbstractUser;
import mk.ukim.finki.emt.usermanagement.domain.models.UserId;
import mk.ukim.finki.emt.usermanagement.domain.repository.UserRepository;
import mk.ukim.finki.emt.usermanagement.services.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public AbstractUser findById(UserId userId) {
        return this.userRepository.findById(userId)
                .orElseThrow(UserIdNotFoundException::new);
    }

    @Override
    public AbstractUser findByUsername(String username) {
        return this.userRepository.findByUsername(username);
    }

    @Override
    public List<AbstractUser> findAll() {
        return this.userRepository.findAll();
    }

    @Override
    public void deleteById(UserId userId) {
        this.userRepository.deleteById(userId);
    }
}
