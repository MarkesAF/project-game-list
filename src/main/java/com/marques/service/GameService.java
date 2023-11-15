package com.marques.service;

import com.marques.dto.GameDTO;
import com.marques.dto.GameMinDTO;
import com.marques.entities.Game;
import com.marques.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository rep;

    @Transactional(readOnly = true)
    public List<GameMinDTO>findAll(){
        List<Game> list = rep.findAll();
        return list.stream().map(GameMinDTO::new).toList();
    }
    @Transactional(readOnly = true)
    public GameDTO findById(Long id){
        Game game = rep.findById(id).get();
        return new GameDTO(game);
    }

}
