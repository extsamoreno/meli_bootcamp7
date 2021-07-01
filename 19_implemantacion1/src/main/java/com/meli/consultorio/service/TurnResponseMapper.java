package com.meli.consultorio.service;

import com.meli.consultorio.dto.response.TurnResponse;
import com.meli.consultorio.model.Turn;

public class TurnResponseMapper {
    public static TurnResponse toResponse(Turn turn){
        return new TurnResponse(turn.getSch_id(), turn.getSch_date(), turn.getSch_patient().getPat_id(), turn.getSch_professional().getPro_id());
    }
}
