package mañana;

import java.util.Date;

public class Fecha {

    private Date fecha;

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public boolean validateDate(Date date){
        return true;
    }

    public Fecha addDay(Date date){
        return new Fecha();
    }

}
