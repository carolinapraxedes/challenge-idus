package com.idus.idus.controller;

import com.idus.idus.entity.AuthenticationResponse;
import com.idus.idus.entity.User;
import com.idus.idus.service.auth.AuthService;
import jakarta.validation.Valid;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.io.Serializable;

@RestController
@RequestMapping("/api/auth")
public class AuthController implements Serializable {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<AuthenticationResponse> register(@Valid @RequestBody User request) {
        return ResponseEntity.ok(authService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody User request) {
        return ResponseEntity.ok(authService.authenticate(request));
    }

    /*@Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private AuthService authService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserDTO userDTO) {

        try {

            Authentication authentication = authService.authenticateUser(userDTO.username(), userDTO.password());

            String jwtToken = jwtUtil.generateToken(authentication.getName());
            // Retorna um JSON mais completo sem uma classe adicional
            return ResponseEntity.ok(jwtToken);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(
                    Map.of("success", false, "message", "Credenciais inválidas")
            );
        }
    }*/
}
