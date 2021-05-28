import java.time.LocalDate;

public class Fecha {

    //private LocalDate fecha;
    private int day, month, year;

    public Fecha() {
        //this.fecha = LocalDate.now();
    }

    public Fecha(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    // Metodos
    public boolean validarFecha(){

        try{
            LocalDate today = LocalDate.of(year, month, day);
        }catch (Exception e){
            System.out.println("La fecha no es valida");
            return false;
        }

        return true;
    }

    public void sumarDia(){
        day++;
    }

    @Override
    public String toString() {
        return "Fecha: " + day+ "/" + month + "/" + year;
    }

    // Getters y Setters
    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
