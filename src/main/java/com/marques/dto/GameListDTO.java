package com.marques.dto;

import com.marques.entities.Game;
import com.marques.entities.GameList;
import lombok.Getter;

@Getter
public class GameListDTO {

    private Long id;
    private String name;

    public GameListDTO(GameList game){
        id = game.getId();
        name = game.getName();
    }
}
