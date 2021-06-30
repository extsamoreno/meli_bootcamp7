package com.meli.consultorio.service;

import com.meli.consultorio.dto.TurnoDTO;
import com.meli.consultorio.dto.util.Mapper;
import com.meli.consultorio.model.Odontologo;
import com.meli.consultorio.model.Paciente;
import com.meli.consultorio.model.Servicio;
import com.meli.consultorio.model.Turno;
import com.meli.consultorio.repository.IOdontologoRepository;
import com.meli.consultorio.repository.IPacienteRepository;
import com.meli.consultorio.repository.IServicioRepository;
import com.meli.consultorio.repository.ITurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class TurnoService implements ITurnoService {

    @Autowired
    ITurnoRepository iTurnoRepository;

    @Autowired
    IPacienteRepository iPacienteRepository;

    @Autowired
    IOdontologoRepository iOdontologoRepository;

    @Autowired
    IServicioRepository iServicioRepository;

    @Override
    public HttpStatus agregarTurno(TurnoDTO turno) throws Exception {
        System.out.println(turno.toString());
        Odontologo odon= iOdontologoRepository.getById(turno.getOdontologo());
        Servicio serv= iServicioRepository.getById(turno.getTipoServicio());
        Paciente pac= iPacienteRepository.getById(turno.getPaciente());
        if (odon== null && serv==null && pac==null){
            throw new Exception("No se encontro odontologo o servicio o paciente");
        }
        Turno turnoResp= Mapper.toTurno(turno);
        turnoResp.setTipoServicio(serv);
        turnoResp.setIdOdontologo(odon);
        turnoResp.setIdPaciente(pac);
        System.out.println(turnoResp.toString());
        iTurnoRepository.save(turnoResp);
        return HttpStatus.CREATED;
    }
}
