package com.example.ApiSpring2.Service;

import com.example.ApiSpring2.Mapper.AlumnoMapper;
import com.example.ApiSpring2.Repositories.IAlumnosNotasRepository;
import com.example.ApiSpring2.dtos.AlumnoDTO;
import com.example.ApiSpring2.dtos.AsignaturaDTO;
import com.example.ApiSpring2.dtos.DiplomaDTO;
import com.example.ApiSpring2.entities.Alumno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiplomaService implements IDiplomaService{

    @Autowired
    IAlumnosNotasRepository iAlumnosNotasRepository;

    @Override
    public DiplomaDTO getDiplomaById(Integer id){
        Alumno alumno = null;
        for(Alumno al : iAlumnosNotasRepository.cargarNotas()){
            if(al.getId() == id) {
                alumno = al;
                break;
            }
        }
        if(alumno!=null) {
            return crearDiploma(AlumnoMapper.toDto(alumno));
        }
        else{
            return null;
        }
    }

    @Override
    public DiplomaDTO getDiploma(AlumnoDTO alumno) {
        return crearDiploma(alumno);
    }

    private DiplomaDTO crearDiploma(AlumnoDTO alumno){
        float promedio = 0;
        int contador = 0;
        for (AsignaturaDTO asignatura : alumno.getSubjects()) {
            promedio += asignatura.getScore();
            contador++;
        }
        promedio = (float) (promedio / (contador));
        String mensaje = promedio > 8 ? "felicidades" : "El alumno "+alumno.getStudentName()+" ha obtenido un promedio de "+promedio;
        return new DiplomaDTO(alumno.getStudentName(),mensaje,promedio,alumno.getSubjects());
    }
}
