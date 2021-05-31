import java.util.Calendar;
import java.util.GregorianCalendar;

public class Fecha {
    int dia,mes,año;

    public Fecha(int dia, int mes, int año) throws Exception {
        if(isDateValid(año,mes,dia)){
            this.dia = dia;
            this.mes = mes;
            this.año = año;
        }else{
            throw new Exception("Error fecha");
        }
    }

    public void mostrarFecha(){
        System.out.println(this.año+"/"+this.mes+"/"+
                this.dia);
    }

    public boolean isDateValid(int año, int mes, int dia) {
        boolean valid = true;
        Calendar calendar = new GregorianCalendar(año, mes-1, dia);
        if (año != calendar.get(Calendar.YEAR)) {
            valid = false;
        }
        else if (mes-1 != calendar.get(Calendar.MONTH)) {
            valid = false;
        }
        else if (dia != calendar.get(Calendar.DAY_OF_MONTH)) {
            valid = false;
        }
        return valid;
    }

    public void sumarDia(int dias){
        mostrarFecha();
        GregorianCalendar date = new GregorianCalendar(this.año , this.mes,this.dia);
        date.add(Calendar.DATE,dias);
        setAño(date.get(Calendar.YEAR));
        setMes(date.get(Calendar.DATE));
        setMes(date.get(Calendar.MONTH));
        mostrarFecha();
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public void setAño(int año) {
        this.año = año;
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
