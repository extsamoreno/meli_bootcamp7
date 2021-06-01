import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Fecha {

    private GregorianCalendar fecha;

    public Fecha() {
    }

    public Fecha(GregorianCalendar fecha) {
        this.fecha = fecha;
    }

    public Fecha(Fecha fecha) {
        this.fecha = fecha.getFecha();
    }



    public  void sumarUnDia() {
        fecha.add(Calendar.DAY_OF_MONTH,1);
    }

    public String getMes(GregorianCalendar fecha) {
        return new SimpleDateFormat("MMMM").format(fecha.getTime());
    }

    public boolean revisarFecha(String fecha){

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            sdf.parse(fecha);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }


    public GregorianCalendar getFecha() {
        return fecha;
    }

    public void setFecha(GregorianCalendar fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString (){
        return "Dia: " + this.fecha.get(Calendar.DAY_OF_MONTH) + ", Mes: " + getMes(this.fecha) + " Año: " + this.fecha.get(Calendar.YEAR);
    }

    public static void main(String[] args) {
        Fecha fecha = new Fecha(new GregorianCalendar());

        System.out.println(fecha.toString());
        fecha.sumarUnDia();
        System.out.println(fecha.toString());

        String fechaAProbar = "12/11/2021";
        if(fecha.revisarFecha(fechaAProbar)){
            System.out.println("La fecha es correcta");
        }else{
            System.out.println("La fecha es incorrecta");
        }
    }
}
