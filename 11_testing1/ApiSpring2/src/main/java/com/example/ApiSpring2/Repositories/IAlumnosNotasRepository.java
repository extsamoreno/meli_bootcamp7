package com.example.ApiSpring2.Repositories;

import com.example.ApiSpring2.entities.Alumno;

import java.util.ArrayList;

public interface IAlumnosNotasRepository {
    public ArrayList<Alumno> cargarNotas();
}
