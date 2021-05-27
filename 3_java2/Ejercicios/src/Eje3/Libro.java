package Eje3;

public class Libro {
    private String titulo;
    private String ISBN;
    private String autor;
    private boolean disponible;

    public Libro prestamo(){
        this.disponible = false;
        return this;
    }

    public void devolucion(){
        this.disponible = true;
    }

    public Libro(){
        this.titulo = "Titulo";
        this.ISBN = "ISBN";
        this.autor = "Autor";
        this.disponible = true;
    }

    public Libro(String titulo, String isbn, String autor, boolean disponible){
        this.titulo = titulo;
        this.ISBN = isbn;
        this.autor = autor;
        this.disponible = disponible;
    }


    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    @Override
    public String toString(){
        return this.titulo + ", " + this.ISBN + ", " + this.autor;
    }
}
