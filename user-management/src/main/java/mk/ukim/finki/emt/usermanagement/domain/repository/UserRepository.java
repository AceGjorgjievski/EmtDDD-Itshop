package mk.ukim.finki.emt.usermanagement.domain.repository;


import mk.ukim.finki.emt.usermanagement.domain.models.AbstractUser;
import mk.ukim.finki.emt.usermanagement.domain.models.UserId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<AbstractUser, UserId> {
    AbstractUser findByUsername(String username);
}
