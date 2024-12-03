package com.idus.idus.controller;


import com.idus.idus.DTO.PointDTO;
import com.idus.idus.entity.Point;
import com.idus.idus.entity.User;
import com.idus.idus.service.PointService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

@RestController
@RequestMapping("/api/point")
public class PointController implements Serializable {

    private PointService pointService;

    @Autowired
    public PointController(PointService pointService) {
        this.pointService = pointService;

    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllPoints() {
        //Todos os registros de ponto
        try {
            List<Point> allPoints = pointService.findAllPoints();
            return ResponseEntity.ok(allPoints);
        } catch (Exception e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro inesperado");
        }
    }

    @PostMapping("/save")
    public ResponseEntity<?> savePoint(@Valid @RequestBody PointDTO pointDTO) {
        //Salvando um registro de ponto
        try {
            Point savedPoint = pointService.savePoint(pointDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedPoint);
        } catch (Exception e) {


            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro inesperado");
        }
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        try {
            Point points = pointService.findByUserId(id);
            return ResponseEntity.ok(points);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao buscar pontos do usuário");
        }
    }


}
