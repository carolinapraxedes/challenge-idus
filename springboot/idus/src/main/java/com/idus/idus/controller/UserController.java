package com.idus.idus.controller;

import com.idus.idus.entity.User;
import com.idus.idus.repository.UserRepository;
import com.idus.idus.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/save")
    // @PreAuthorize("hasRole('USER')
    public ResponseEntity<?> saveUser(@Valid @RequestBody User user, BindingResult result) {
        if (result.hasErrors()) {
            // Lógica para retornar erros de validação
            return ResponseEntity.badRequest().body(result.getAllErrors());
        }
        User savedUser = userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }


    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = userService.getUserById(id);
        if (user == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(user);
    }
}
