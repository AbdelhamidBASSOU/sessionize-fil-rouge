package Sessionize.service.impl;

import Sessionize.entity.Role;
import Sessionize.entity.User;
import Sessionize.repository.RoleRepository;
import Sessionize.repository.UserRepository;
import Sessionize.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Override
    public Optional<User> getOneById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public User addUser(User user) {
       // String pw = user.getPassword();
       // user.setPassword(passwordEncoder.encode(pw));
        return userRepository.save(user);
    }

    @Override
    public User updateUser(Long userId, User updatedUser) {
        User userToUpdate = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalStateException("User not found with id: " + userId));

        userToUpdate.setFullName(updatedUser.getFullName());
        userToUpdate.setUsername(updatedUser.getUsername());
        userToUpdate.setPassword(updatedUser.getPassword());
        userToUpdate.setEmail(updatedUser.getEmail());
        userToUpdate.setPhone(updatedUser.getPhone());
        userToUpdate.setRole(updatedUser.getRole());

        return userRepository.save(userToUpdate);
    }

    @Override
    public User findByEmail(String email) {
        User users = userRepository.findByEmail(email);
        return users;
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        User user = userRepository.findByUsername(username);
        Role role = roleRepository.findByName(roleName);
        user.setRole(role);
    }

    @Override
    public User loadUserByUsername(String username) {
        return userRepository.findByUsername(username);

    }
}
