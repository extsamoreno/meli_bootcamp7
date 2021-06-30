package com.appconsultorio.appconsultorio.service;
import com.appconsultorio.appconsultorio.model.Odontologo;
import com.appconsultorio.appconsultorio.model.Paciente;
import com.appconsultorio.appconsultorio.model.Turno;
import com.appconsultorio.appconsultorio.repository.IOdontologoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OdontologoService implements IOdontologoService {

    IOdontologoRepository iOdontologoRepository;

    @Override
    public void crearOdontologo(Odontologo odontologo) {
        iOdontologoRepository.save(odontologo);
    }

    @Override
    public void editarOdontologo(Odontologo odontologo) {
        iOdontologoRepository.save(odontologo);
    }

    @Override
    public void eliminarOdontologo(int id) {
        iOdontologoRepository.deleteById(id);
    }

    @Override
    public List<Odontologo> obtenerOdontologos() {
        return iOdontologoRepository.findAll();
    }
}
