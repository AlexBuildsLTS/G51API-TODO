package se.alex.lexicon.g51todoapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.alex.lexicon.g51todoapi.domain.dto.UserDTOForm;
import se.alex.lexicon.g51todoapi.domain.dto.UserDTOView;
import se.alex.lexicon.g51todoapi.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<UserDTOView> registerUser(@RequestBody UserDTOForm userDTOForm) {
        UserDTOView createdUser = userService.register(userDTOForm);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

    @GetMapping
    public ResponseEntity<List<UserDTOView>> getAllUsers() {
        List<UserDTOView> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{email}")
    public ResponseEntity<UserDTOView> getUserByEmail(@PathVariable String email) {
        UserDTOView user = userService.getByEmail(email);
        return ResponseEntity.ok(user);
    }

    @PutMapping("/{email}/disable")
    public ResponseEntity<Void> disableUser(@PathVariable String email) {
        userService.disableUserByEmail(email);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{email}/enable")
    public ResponseEntity<Void> enableUser(@PathVariable String email) {
        userService.enableUserByEmail(email);
        return ResponseEntity.noContent().build();
    }
}