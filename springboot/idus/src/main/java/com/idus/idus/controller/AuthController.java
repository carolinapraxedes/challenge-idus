package com.idus.idus.controller;

import com.idus.idus.DTO.UserDTO;
import com.idus.idus.security.JwtUtil;
import com.idus.idus.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private AuthService authService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserDTO userDTO) {
            /*
            try{
                Long variavel = userDTO();
                authService.auth();
            }catch (){

            }
            */
//        Authentication authentication = authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
//
//        return jwtUtil.generateToken(authentication.getName());
    }
}
