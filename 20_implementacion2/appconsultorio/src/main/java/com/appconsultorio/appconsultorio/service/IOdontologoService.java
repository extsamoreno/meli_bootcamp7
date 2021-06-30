package com.appconsultorio.appconsultorio.service;
import com.appconsultorio.appconsultorio.model.Odontologo;
import com.appconsultorio.appconsultorio.model.Turno;
import java.util.List;

public interface IOdontologoService {
    public void crearOdontologo(Odontologo odontologo);
    public void editarOdontologo(Odontologo odontologo);
    public void eliminarOdontologo(int id);
    public List<Odontologo> obtenerOdontologos() ;
}
