import java.util.Date;
import java.util.GregorianCalendar;

public class Fecha {
    /*Crea una clase Fecha. La clase contendrá además de los constructores que consideres adecuados,
    métodos de acceso y el método toString, tal como lo explicamos en el ejercicio anterior,
     un método para comprobar si la fecha es correcta y otro para sumarle un día al valor actual de la fecha.
    Se debe investigar y utilizar la clase GregorianCalendar para implementar los métodos y constructores de Fecha.
     */
    private int dia;
    private int mes;
    private int anio;


    public Fecha(){

    }
    public Fecha(int dia, int mes, int anio){
        this.dia=dia;
        this.mes=mes;
        this.anio=anio;
    }

    public boolean fechaEsCorrecta(Date fecha){

        //implementacion

        return true;
    }

    public Date sumarDia(Date fecha, int cantDias){
        Date d = new Date();

        //implementacion con gregoriancalendar

        return d;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    @Override
    public String toString(){
        return "";
    }
}
