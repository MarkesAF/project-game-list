package com.marques.controller;

import com.marques.dto.GameListDTO;
import com.marques.dto.GameMinDTO;
import com.marques.service.GameListService;
import com.marques.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

    @Autowired
    private GameListService service;

    @Autowired
    private GameService gameService;

    @GetMapping
    public ResponseEntity<List<GameListDTO>>findAll(){
        List<GameListDTO> dto = service.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @GetMapping(value = "/{listId}/games")
    public ResponseEntity<List<GameMinDTO>>findByList(@PathVariable Long listId){
        List<GameMinDTO>list = gameService.findByList(listId);
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }
}
