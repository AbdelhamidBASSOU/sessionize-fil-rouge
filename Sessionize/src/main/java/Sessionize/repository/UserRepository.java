package Sessionize.repository;

import Sessionize.entity.Role;
import Sessionize.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    @Override
    Optional<User> findById(Long aLong);

    User findByEmail(String email);

    User findByUsername(String username);

    User findByUsernameAndRole(String username , Role role);
}
