package ej2;

import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.Period;

@Service
public class EdadCore {
    public static int getEdad(int dia, int mes, int ano) {
        LocalDate date = LocalDate.of(ano, mes, dia);
        Period diff= Period.between(date, LocalDate.now());
        return diff.getYears();
    }
}
