package fecha;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.GregorianCalendar;

/*Crea una clase Fecha. La clase contendrá además de los constructores que consideres adecuados,
métodos de acceso y el método toString, tal como lo explicamos en el ejercicio anterior,
un método para comprobar si la fecha es correcta y otro para sumarle un día al valor actual de la fecha.
Se debe investigar y utilizar la clase GregorianCalendar para implementar los métodos y constructores de Fecha.*/
public class Fecha {
    private int dia;
    private int mes;
    private int año;

    public Fecha() {
    }

    public Fecha(int dia, int mes, int año) {
        if (validarFecha(dia, mes, año)) {
            this.dia = dia;
            this.mes = mes;
            this.año = año;
        } else {
            //System.out.println("Fecha inválida");
        }
    }

    public Fecha(Fecha fecha) {
        this(fecha.getDia(), fecha.getMes(), fecha.getAño());
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public void agregarDia() {
        GregorianCalendar calendar = new GregorianCalendar(this.año, this.mes, this.dia);
        calendar.add(GregorianCalendar.DAY_OF_MONTH, 1);

        System.out.println("calendar.toString() = " + calendar.toString());
    }

    public boolean validarFecha(int dia, int mes, int año) {
        try {
            LocalDate ld = LocalDate.of(año, mes, dia);
            return true;
        } catch (DateTimeException e) {
            return false;
        }
    }

    @Override
    public String toString() {
        return "Fecha:" + dia +
                "/" + mes +
                "/" + año;
    }


}
