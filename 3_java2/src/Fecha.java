import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.GregorianCalendar;

public class Fecha {
    private GregorianCalendar fecha;
    private int anio, mes, dia;

    public Fecha() {
    }

    public Fecha(int anio, int mes, int dia) {
        this.fecha= new GregorianCalendar(anio,mes-1,dia);
        this.anio=anio;
        this.mes=mes-1;
        this.dia=dia;
    }

    public boolean esValida(){
        try{
            LocalDate day = LocalDate.of(this.anio, this.mes+1, this.dia);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public void addDay(){
        this.fecha.add(GregorianCalendar.DAY_OF_MONTH, 1);
    }

    public GregorianCalendar getFecha() {
        return fecha;
    }

    public void setFecha(GregorianCalendar fecha) {
        this.fecha = fecha;
    }
}
