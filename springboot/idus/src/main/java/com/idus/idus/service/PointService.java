package com.idus.idus.service;

import com.idus.idus.DTO.PointDTO;
import com.idus.idus.entity.Point;
import com.idus.idus.entity.User;
import com.idus.idus.repository.PointRepository;
import com.idus.idus.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PointService {

    @Autowired
    private PointRepository pointRepository;
    @Autowired
    private UserRepository userRepository;

    @Transactional
    public Point savePoint(PointDTO pointDTO) {
        try {
           Long userid = pointDTO.user_id();
           User user = userRepository.findById(userid).orElseThrow();
           Point point = new Point();
           point.setTimestamp(LocalDateTime.now());
           point.setUser(user);
           return pointRepository.save(point);

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Erro: " + e.getMessage());
        }
    }

    public Point findByUserId(Long userId) {
        try {
            return pointRepository.findById(userId).stream().findFirst().orElseThrow();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Erro: " + e.getMessage());
        }
    }

    public List<Point> findAllPoints() {
        try {
            return pointRepository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            throw  new RuntimeException("Erro: " + e.getMessage());
        }
    }
}

