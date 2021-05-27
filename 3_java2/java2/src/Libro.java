import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Libro {
    /* Crea una clase Libro con los métodos: préstamo, devolución y toString, cuyo prototipo debe ser: public String toString().
    Este método debe retornar una cadena que represente al objeto.
    Por ejemplo: si la clase tiene los atributos: título, isbn y autor,
    una cadena que represente a un libro podría ser: “Harry Potter, 9780545582889, Rowling, J. K.”.
    La clase contendrá un constructor por defecto, un constructor con parámetros y los métodos de acceso.
    Agregar la línea @Override justo arriba del encabezado del método toString.
    Luego, cambiar el nombre del método por: tostring (todo en minuscula) que sucede?*/

    public static void main(String[] args) {
        Libro l = new Libro("Harry postre","Messi",new Date(23/04/1992));
        System.out.println(l.toString());
    }


    private String titulo;
    private String autor;
    private Date fechaCreacion;
    private String personaPrestamo;
    private Date fechaDevolucion;
    private boolean estaPrestado;

    @Override
    public String toString(){
        return "\""+this.titulo+", "+this.autor+", "+this.fechaCreacion+"\"";
    }

    public Libro(){

    }

    public Libro(String titulo, String autor, Date fechaCreacion){
        this.titulo=titulo;
        this.autor=autor;
        this.fechaCreacion = fechaCreacion;
    }
    public Libro(String titulo, String autor, Date fechaCreacion, boolean estaPrestado, String personaPrestamo, Date fechaDevolucion){
        this.titulo=titulo;
        this.autor=autor;
        this.fechaCreacion = fechaCreacion;
        this.estaPrestado=estaPrestado;
        this.personaPrestamo=personaPrestamo;
        this.fechaDevolucion=fechaDevolucion;
    }

    public boolean prestamo (String personaPrestamo, Date fechaDevolucion){
        if(this.estaPrestado==false){
            this.personaPrestamo = personaPrestamo;
            this.fechaDevolucion = fechaDevolucion;
            this.estaPrestado = true;
            return true;
        }
        return false;
    }

    public boolean devolucion (){
        if(this.estaPrestado==true){
            estaPrestado=false;
            return true;
        }
        return false;
    }


}
