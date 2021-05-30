package TM;

import java.util.GregorianCalendar;
import java.util.Calendar;
import java.text.SimpleDateFormat;

public class Fecha {

    private long timestamp;
    private Integer dia, mes, año;

    public Fecha() {
        this.dia = 0;
        this.mes = 0;
        this.año = 0;
    }

    public Fecha(int dia, int mes, int año){
        this.dia = dia;
        this.mes = mes;
        this.año = año;
    }

    public String getFecha(){
        return this.toString();
    }

    public Fecha getFechaActual(){

        Calendar fecha = GregorianCalendar.getInstance();

        this.dia = fecha.get(Calendar.DAY_OF_MONTH);
        this.mes = fecha.get(Calendar.MONTH) + 1;
        this.año = fecha.get(Calendar.YEAR);
        this.timestamp = fecha.getTimeInMillis();

        System.out.println("Dia: " + this.dia);
        System.out.println("Mes: " + this.mes);
        System.out.println("Año: " + this.año);

        return this;
    }

    public boolean isCorrect(Fecha fecha){
        boolean res = false;

        if ((this.dia > 0 && this.dia <= 31) && (this.mes > 0 && this.mes <= 12) && (this.año > 1900 && this.año <= 9999)) {
            res = true;
        }
        return res;
    }

    public boolean addDay() throws Exception{
        boolean res = false;

        if(this.dia==0 && this.año==0 && this.mes==0){
            throw new Exception("No se puede agregar un dia, no hay fecha cargada");
        }else{
            for (int i=1;i<=3;i++){
                if(this.isBorderCase(i)) {
                    if (i == 1) this.dia = 1;
                    if (i == 2) this.mes = 1;
                    if (i == 3) this.año = 1900;
                } else if(i==1) {
                    this.dia += 1;
                }
            }
        }
        return res;
    }

    // Argumento, dia:1, mes:2, año:3
    private boolean isBorderCase(int arg){
        boolean res = false;
        if(arg == 1 && this.dia >= 31){
            res = true;
        }
        if(arg == 2 && this.mes >= 12){
            res = true;
        }
        if(arg == 3 && this.año >= 9999){
            res = true;
        }
        return res;
    }


    @Override
    public String toString(){
        return (this.dia.toString() + "/" + this.mes.toString() + "/" + this.año.toString());
    }


}
