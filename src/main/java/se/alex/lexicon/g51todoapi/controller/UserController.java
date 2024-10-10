package se.alex.lexicon.g51todoapi.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.alex.lexicon.g51todoapi.domain.dto.UserDTOForm;
import se.alex.lexicon.g51todoapi.domain.dto.UserDTOView;
import se.alex.lexicon.g51todoapi.service.UserService;

import java.util.List;

/**
 * REST Controller for managing User-related operations.
 */
@Valid
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserDTOView> registerUser(@Valid @RequestBody UserDTOForm userDTOForm) {
        UserDTOView userDTOView = userService.register(userDTOForm);
        return new ResponseEntity<>(userDTOView, HttpStatus.CREATED);
    }

    @GetMapping("/{email}")
    public ResponseEntity<UserDTOView> getUserByEmail(@PathVariable String email) {
        UserDTOView userDTOView = userService.getByEmail(email);
        if (userDTOView == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(userDTOView, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<UserDTOView>> getAllUsers() {
        List<UserDTOView> users = (List < UserDTOView >) userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PutMapping("/{email}/disable")
    public ResponseEntity<Void> disableUser(@PathVariable String email) {
        try {
            userService.disableByEmail(email);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{email}/enable")
    public ResponseEntity<Void> enableUser(@PathVariable String email) {
        try {
            userService.enableByEmail(email);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
