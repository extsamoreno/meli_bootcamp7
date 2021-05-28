import java.util.Calendar;
import java.util.GregorianCalendar;

public class Fecha {
    int dia,mes,año;
    private GregorianCalendar calendar;

    public Fecha(int dia, int mes, int año) {
        this.calendar = (GregorianCalendar) GregorianCalendar.getInstance();
        this.calendar.set(año,dia,mes);
        this.dia = dia;
        this.mes = mes;
        this.año = año;
    }

    public void mostrarFecha(){
        System.out.println(this.calendar.get(Calendar.YEAR)+"/"+this.calendar.get(Calendar.MONTH)+"/"+
                this.calendar.get(Calendar.DATE));
    }

    public void sumarDia(int dias){
        System.out.println("Fecha actual");
        mostrarFecha();
        this.calendar.add(Calendar.DATE,dias);
        System.out.println("Dia sumado");
        mostrarFecha();
    }

    @Override
    public String toString() {
        return "Fecha{" +
                "dia=" + dia +
                ", mes=" + mes +
                ", año=" + año +
                '}';
    }
}
