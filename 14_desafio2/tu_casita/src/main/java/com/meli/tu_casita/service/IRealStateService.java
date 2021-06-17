package com.meli.tu_casita.service;

import com.meli.tu_casita.model.dto.EnvironmentDTO;
import com.meli.tu_casita.model.dto.RealStateInDTO;
import com.meli.tu_casita.model.dto.RealStateOutDTO;

import java.util.List;

public interface IRealStateService {

    float getRealStateTotalMeters(int realStateId);

    float getRealStateTotalPrice(int realStateId);

    EnvironmentDTO getRealStateBiggestEnvironmentByRealStateId(int realStateId);

    List<EnvironmentDTO> getEnvironmentTotalMetersListByRealStateId(int realStateId);

    List<RealStateOutDTO> getRealStateList();

    void addNewRealState(RealStateInDTO realStateInDTO);

    RealStateOutDTO getRealStateOutDTOByRealStateName(String name);

    RealStateOutDTO getRealStateOutDTOByRealStateId(int id);
}
