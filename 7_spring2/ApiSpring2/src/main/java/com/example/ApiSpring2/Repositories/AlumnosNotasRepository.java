package com.example.ApiSpring2.Repositories;

import com.example.ApiSpring2.dtos.AlumnoDTO;
import com.example.ApiSpring2.dtos.AsignaturaDTO;
import com.example.ApiSpring2.entities.Alumno;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class AlumnosNotasRepository {

    public static ArrayList<Alumno> cargarNotas(){
        ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
        int contador = 0;
        ArrayList<AsignaturaDTO> notasFederico = new ArrayList<AsignaturaDTO>();
        notasFederico.add(new AsignaturaDTO("Matematica",(short)3));
        notasFederico.add(new AsignaturaDTO("Historia",(short)3));
        notasFederico.add(new AsignaturaDTO("Biologia", (short)12));
        alumnos.add(new Alumno(contador,"Federico", notasFederico));

        ArrayList<AsignaturaDTO> notasLautaro = new ArrayList<AsignaturaDTO>();
        notasLautaro.add(new AsignaturaDTO("Matematica",(short)9));
        notasLautaro.add(new AsignaturaDTO("Historia",(short)10));
        notasLautaro.add(new AsignaturaDTO("Biologia", (short)3));
        alumnos.add(new Alumno(contador,"Lautaro", notasLautaro));

        return alumnos;
    }
}
