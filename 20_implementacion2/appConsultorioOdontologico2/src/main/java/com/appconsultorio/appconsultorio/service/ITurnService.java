package com.appconsultorio.appconsultorio.service;
import com.appconsultorio.appconsultorio.dtos.request.TurnDTO;
import com.appconsultorio.appconsultorio.model.Turn;

import java.util.List;

public interface ITurnService {
    void createTurn(TurnDTO turnDTO) throws Exception;
    void updateTurn(Turn turn);
    void removeTurn(int id);
    List<Turn> getTurn();
    List<Turn> findTurnosLikeFinalizado();
    List<Turn> findTurnosLikeReprogramed();
    //void createReprogramedTurn(TurnDTO turnDTO) throws Exception;
}
