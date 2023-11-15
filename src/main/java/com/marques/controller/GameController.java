package com.marques.controller;

import com.marques.dto.GameDTO;
import com.marques.entities.Game;
import com.marques.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/games")
public class GameController {

    @Autowired
    private GameService service;


    @GetMapping
    public ResponseEntity<List<GameDTO>>findAll(){
        List<GameDTO> list = service.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }
}
