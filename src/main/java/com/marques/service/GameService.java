package com.marques.service;

import com.marques.dto.GameDTO;
import com.marques.entities.Game;
import com.marques.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository rep;

    public List<GameDTO>findAll(){
        List<Game> list = rep.findAll();
        return list.stream().map(GameDTO::new).toList();
    }

}
