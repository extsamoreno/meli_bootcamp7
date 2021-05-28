package meli.ejerc;

public class Libro {

    private String titulo;
    private long isbn;
    private String autor;

    public Libro() {
    }

    public Libro(String titulo, long isbn, String autor) {
        this.titulo = titulo;
        this.isbn = isbn;
        this.autor = autor;
    }

    public void prestamo() {
    }

    public void devolucion() {
    }

    @Override
    public String toString() {
        return titulo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public long getIsbn() {
        return isbn;
    }

    public void setIsbn(long isbn) {
        this.isbn = isbn;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
}
