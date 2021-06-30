package com.meli.consultorio.service;

import com.meli.consultorio.dto.TurnoDTO;
import org.springframework.http.HttpStatus;

public interface ITurnoService {
    public HttpStatus agregarTurno(TurnoDTO turno) throws Exception;
}
