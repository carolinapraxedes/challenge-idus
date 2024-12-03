package com.idus.idus.service;

import com.idus.idus.DTO.PointDTO;
import com.idus.idus.entity.Point;
import com.idus.idus.entity.User;
import jakarta.transaction.Transactional;

import java.time.LocalDateTime;

public class AuthService {

    @Transactional
    public String auth() {
        try {


        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Erro: " + e.getMessage());
        }
    }
}
