package primerejercicio.metrocuadrado.web.service;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;

@Service
public class ServiceEdad {

    public int calcularEdad(String dia, String mes, String anio) {
        Period edad = Period.between(LocalDate.of(Integer.parseInt(anio), Integer.parseInt(mes), Integer.parseInt(dia)), LocalDate.now());
        return edad.getYears();
    }
}
