package com.marques.controller;

import com.marques.dto.GameListDTO;
import com.marques.service.GameListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/gamelist")
public class GameListController {

    @Autowired
    private GameListService service;


    @GetMapping
    public ResponseEntity<List<GameListDTO>>findAll(){
        List<GameListDTO> dto = service.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
}
