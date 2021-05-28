package ejercicio5;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.GregorianCalendar;

public class Fecha {
    private int dia;
    private int mes;
    private int anio;
    private GregorianCalendar fecha;

    public Fecha(int dia, int mes, int anio){
        validarFecha(dia,mes,anio);
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
    }

    public Fecha(){
    }

    public Fecha(Fecha fecha){
        validarFecha(fecha.getDia(),fecha.getMes(),fecha.getAnio());
        this.dia = fecha.getDia();
        this.mes = fecha.getMes();
        this.anio = fecha.getAnio();
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

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public GregorianCalendar getFecha() {
        return fecha;
    }

    public void setFecha(GregorianCalendar fecha) {
        this.fecha = fecha;
    }

    public void agregarDia(){
        this.fecha.add(GregorianCalendar.DAY_OF_MONTH,1);
    }

    public boolean validarFecha(int dia, int mes, int anio){
        try {
            LocalDate ld = LocalDate.of( anio , mes , dia);
            return true ;  // true = Valid data entered for a date.
        } catch ( DateTimeException e ) {
            return false;  // Exception caught, meaning invalid data-entry.
        } finally {
            System.out.println( "Fecha inválida :(");
        }

    }

    @Override
    public String toString() {
        return dia + "/" + mes + "/" + anio;
    }
}