package com.appconsultorio.appconsultorio.service;
import com.appconsultorio.appconsultorio.model.Dentist;
import com.appconsultorio.appconsultorio.model.Turn;

import java.util.List;

public interface ITurnService {
    public void createTurn(Turn turn);
    public void updateTurn(Turn turn);
    public void removeTurn(int id);
    public List<Turn> getTurn() ;
}
