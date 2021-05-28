import java.util.Calendar;
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
        GregorianCalendar c = new GregorianCalendar();
        c.set(anio, mes, dia);
        c.setLenient(false);
        try{
            c.getTime();
            this.dia=dia;
            this.mes=mes;
            this.anio=anio;
            System.out.println("Fecha valida");
        }catch(Exception e){
            System.out.println("Fecha invalida");
            e.printStackTrace();
        }




    }

    public static void main(String[] args) {
        int dia = 9, mes = 3, anio=1990;

        Fecha f = new Fecha(dia,mes,anio);
        System.out.println(f.toString());
        GregorianCalendar g = f.sumarDia(111);
        f.anio= g.get(Calendar.YEAR);
        f.mes= g.get(Calendar.MONTH);
        f.dia= g.get(Calendar.DAY_OF_MONTH);
        System.out.println(f.toString());
    }



    public GregorianCalendar sumarDia(int cantDias){

        GregorianCalendar g = new GregorianCalendar();
        g.set(anio, mes, dia);
        g.setLenient(false);
        g.add(Calendar.DAY_OF_MONTH, cantDias);
        try{
             g.getTime();
             return g;
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    @Override
    public String toString(){
        return "DIA: "+dia+" MES: "+mes+" ANIO: "+anio;
    }
}
