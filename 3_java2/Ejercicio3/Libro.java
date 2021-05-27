package Ejercicio3;

public class Libro {
    //Atributos
    String titulo;
    String ISBN;
    String Autor;
    Boolean enPrestamo;

    //Constructores

    public Libro(){
        this.titulo="sin titulo";
        this.ISBN="000";
        this.Autor="Agrear autor";
        this.enPrestamo = false;
    }
    public Libro(String titulo, String ISBN, String Autor, Boolean enPrestamo){
        this.titulo=titulo;
        this.ISBN=ISBN;
        this.Autor=Autor;
        this.enPrestamo=enPrestamo;
    }

    // getters y setters


    public String getTitulo() {
        return titulo;
    }

    public String getISBN() {
        return ISBN;
    }

    public String getAutor() {
        return Autor;
    }

    public Boolean getEnPrestamo() {
        return enPrestamo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public void setAutor(String autor) {
        Autor = autor;
    }

    public void setEnPrestamo(Boolean enPrestamo) {
        this.enPrestamo = enPrestamo;
    }

    //Metodos
    public  static void prestamo(Libro libro){
        if(libro.enPrestamo) System.out.println("El libro ya se encuentra en prestamo");
        else{
            System.out.println("OK!!, Libro prestado");
            libro.enPrestamo=true;
        }
    }
    public static void devolucion(Libro libro){
        if(libro.enPrestamo){
            System.out.println("Libro devuelto correctamente.");
            libro.enPrestamo=false;
        }
        else System.out.println("No se puede devolver, porque no se encuentra en prestamo");
    }

    @Override
    public String toString() {
        return "Libro{" +
                "titulo='" + titulo + '\'' +
                ", ISBN='" + ISBN + '\'' +
                ", Autor='" + Autor + '\'' +
                ", enPrestamo=" + enPrestamo +
                '}';
    }
}
