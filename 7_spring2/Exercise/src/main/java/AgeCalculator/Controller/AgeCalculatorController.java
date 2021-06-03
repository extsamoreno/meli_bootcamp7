package AgeCalculator.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;


@RestController
@RequestMapping("/agecalculator")
public class AgeCalculatorController {
    @GetMapping("/edad/{day}/{month}/{year}")
    public String getEdad(@PathVariable Integer day, @PathVariable Integer month, @PathVariable Integer year) throws ParseException {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        LocalDate fechaIni = LocalDate.of(year, month, day);
        LocalDate fechaFin = LocalDate.now();

        Period periodo = Period.between(fechaIni, fechaFin);
        return ("Años: " + periodo.getYears()+" meses: "+periodo.getMonths()+ " dias: "+ periodo.getDays());
    }
}
