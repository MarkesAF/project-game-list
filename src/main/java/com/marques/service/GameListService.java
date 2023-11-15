package com.marques.service;

import com.marques.dto.GameListDTO;
import com.marques.entities.GameList;
import com.marques.repository.GameListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameListService {

    @Autowired
    private GameListRepository rep;

    public List<GameListDTO>findAll(){
        List<GameList>list = rep.findAll();
        return list.stream().map(GameListDTO::new).toList();
    }
}
