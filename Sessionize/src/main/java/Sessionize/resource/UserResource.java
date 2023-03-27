package Sessionize.resource;

import Sessionize.entity.User;
import Sessionize.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserResource {
    private final UserService userservice;

    @PostMapping("/add")
    public User addUser(@RequestBody User user){
        return userservice.addUser(user);
    }

    @PutMapping("{user_id}")
    public User updateUser(@PathVariable Long user_id, @RequestBody User user){
        return userservice.updateUser(user_id,user);
    }
    @GetMapping("/")
    public List<User> getUsers(){
        return userservice.getAll();
    }
}
