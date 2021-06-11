package com.example.ApiSpring2.Repositories;

import com.example.ApiSpring2.dtos.AlumnoDTO;
import com.example.ApiSpring2.dtos.AsignaturaDTO;
import com.example.ApiSpring2.entities.Alumno;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Array;
import java.util.ArrayList;

@Repository
public class AlumnosNotasRepository implements IAlumnosNotasRepository{

    ArrayList<Alumno> alumnos = new ArrayList<>();

    public void cargarDb(){
        ArrayList<AsignaturaDTO> notasFederico = new ArrayList<AsignaturaDTO>();
        notasFederico.add(new AsignaturaDTO("Matematica",(short)3));
        notasFederico.add(new AsignaturaDTO("Historia",(short)3));
        notasFederico.add(new AsignaturaDTO("Biologia", (short)10));
        alumnos.add(new Alumno(nextId(),"Federico", notasFederico));
        ArrayList<AsignaturaDTO> notasLautaro = new ArrayList<AsignaturaDTO>();
        notasLautaro.add(new AsignaturaDTO("Matematica",(short)9));
        notasLautaro.add(new AsignaturaDTO("Historia",(short)10));
        notasLautaro.add(new AsignaturaDTO("Biologia", (short)3));
        alumnos.add(new Alumno(nextId(),"Lautaro", notasLautaro));
    }

    @Override
    public ArrayList<Alumno> cargarNotas(){
        return alumnos;
    }

    private int nextId(){
        return alumnos.size()+1;
    }
}
