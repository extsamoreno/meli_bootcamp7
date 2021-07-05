package com.meli.consultorio.service;

import com.meli.consultorio.dto.response.TurnResponse;
import com.meli.consultorio.model.Turn;

public class TurnResponseMapper {
    public static TurnResponse toResponse(Turn turn){
        return new TurnResponse(turn.getTur_id(), turn.getTur_date(), turn.getTur_patient().getPat_id(), turn.getTur_professional().getPro_id());
    }
}
