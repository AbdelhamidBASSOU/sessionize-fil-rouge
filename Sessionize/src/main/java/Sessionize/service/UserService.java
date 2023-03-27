package Sessionize.service;

import Sessionize.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {
    Optional<User> getOneById(Long id);
    User addUser(User user);
    User updateUser(Long id, User user);

    User findByEmail(String email);

    List<User> getAll();

    void addRoleToUser(String username, String roleName);

    User loadUserByUsername(String username);
}
