package controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import model.User;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;
import service.UserService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
@Tag(name = "User", description = "User management APIs")
public class UserController {

    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/admin")
    @Operation(summary = "Get all Users", description = "Get all Users in the system")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @PutMapping("/admin/{id}")
    @Operation(summary = "Update User", description = "Update a User in the system")
    public User updateUser(@PathVariable Long id, @RequestBody User userDetails){
        return userService.updateUser(id, userDetails);
    }

    @DeleteMapping("/admin/{id}")
    @Operation(summary = "Delete User", description = "Delete a User in the system")
    public Optional<User> deleteUser(@PathVariable Long id){
        return userService.deleteUser(id);
    }
    
}
