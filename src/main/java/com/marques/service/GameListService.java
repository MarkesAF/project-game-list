package com.marques.service;

import com.marques.dto.GameListDTO;
import com.marques.entities.GameList;
import com.marques.projections.GameMinProjection;
import com.marques.repository.GameListRepository;
import com.marques.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {

    @Autowired
    private GameRepository gameRep;

    @Autowired
    private GameListRepository rep;

    @Transactional(readOnly = true)
    public List<GameListDTO>findAll(){
        List<GameList>list = rep.findAll();
        return list.stream().map(GameListDTO::new).toList();
    }
    @Transactional
    public void move(Long listId, int sourceIndex, int destinationIndex){

        List<GameMinProjection> list = gameRep.searchByList(listId);
        GameMinProjection obj = list.remove(sourceIndex);
        list.add(destinationIndex,obj);

        int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
        int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;

        for(int i = min; i <=max; i++){
            rep.updateBelongingPosition(listId,list.get(i).getId(),i);
        }
    }
}
