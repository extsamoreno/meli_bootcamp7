import java.util.Calendar;
import java.util.GregorianCalendar;
public class Fecha {

    private int dia, mes, anio;
    private Calendar fecha;

    //contructores
    public Fecha(){
        this.fecha = new GregorianCalendar();
    }

    public Fecha(int dia, int mes, int anio){
        boolean resultado = esCorrecta(dia, mes, anio);
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
    }


    //get and set
    public int getDia(){
        return this.fecha.get(Calendar.DATE);
    }

    public void setDia(int dia){
        this.fecha.set(Calendar.DATE,dia);
    }

    public int getMes(){
        return this.fecha.get(Calendar.MONTH);
    }

    public void setMes(){
        this.fecha.set(Calendar.MONTH,mes);
    }

    public int getAnio(){
        return this.fecha.get(Calendar.YEAR);
    }

    public void setAnio(int anio){
        this.fecha.set(Calendar.YEAR, anio);
    }



    //metodos
    public void sumarDia(){
        this.fecha.add(Calendar.DATE,1);

    }

    //Consultar por que no corrige el mes y el dia, cuando me paso de los 30 dias del mes por ej
    public boolean esCorrecta(int dia, int mes, int anio){
       // Calendar fechaN = new GregorianCalendar(anio,mes,dia);

        Calendar fechaN = Calendar.getInstance();
        fechaN.set(anio, mes, dia);
        if((fechaN.get(Calendar.DATE))==(dia) && (fechaN.get(Calendar.MONTH))==(mes) && (fechaN.get(Calendar.YEAR))==(anio)){
            this.fecha = fechaN; //Caso de exito
            return true;
        } else {
            //Caso de falla
            this.fecha = new GregorianCalendar();
            System.out.println("Fecha invalida! :(  Se genera fecha actual");
        }
        return false;
    }


    @Override
    public String toString(){
        return this.dia + "/" + this.mes + "/" + this.anio;
    }
}


