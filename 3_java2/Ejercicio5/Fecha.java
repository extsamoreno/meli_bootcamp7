package Ejercicio5;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Fecha {
    //Atributos
    int dia;
    int mes;
    int anio;



    //Contructor
    public Fecha(){
        dia=1;
        mes=1;
        anio=2021;
    }
    public Fecha(int dia,int mes, int anio){
        this.dia=dia;
        this.mes=mes;
        this.anio=anio;
    }

    // Getters y setters
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

    // metodos

    public static boolean  isCorrectDate(Fecha fecha){//revisar metodo
        GregorianCalendar calendario = new GregorianCalendar(fecha.anio,fecha.mes,fecha.dia);
        return calendario.isLenient();
    }
    public GregorianCalendar addDay(){
        GregorianCalendar calendario = new GregorianCalendar(anio,mes,dia);
        calendario.add(Calendar.DAY_OF_MONTH,1);
        return calendario;
    }
}
