package bootcamp.desafio.spring.util;

import bootcamp.desafio.spring.exception.DateException;
import org.springframework.http.HttpStatus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Utils {

    /**
     * metodo para obtener los dias entre una fecha dada y la actualidad
     * @param date
     * @return
     */
     public static long getDaysMinusNow(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        Date now = new Date();
        long diff = now.getTime() - date.getTime();
        TimeUnit time = TimeUnit.DAYS;
        long diffrence = time.convert(diff, TimeUnit.MILLISECONDS);
        return diffrence;
    }


    /**
     * Permite convertir un String en fecha (Date).
     * @param fecha Cadena de fecha dd-MM-yyyy
     * @return Objeto Date
     */
    public static Date ParseFecha(String fecha) throws DateException {
        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
        Date fechaDate = null;
        try {
            if(fecha== null ||  fecha.isEmpty() ){
                fechaDate= new Date();
            }
            else {
                fechaDate = formato.parse(fecha);
            }

        }
        catch (ParseException ex)
        {
            throw new DateException("la fecha no tiene un buen formato, el formato es dd-mm-yyyy como por ejemplo 29-04-2021.", HttpStatus.BAD_REQUEST);
        }
        if(new Date().before(fechaDate)){
            throw new DateException("la fecha no puede ser futura.", HttpStatus.BAD_REQUEST);
        }
        return fechaDate;
    }
}
