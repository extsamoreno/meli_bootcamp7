package com.ejercitacion.mañana;

public class Libro {

    private String titulo;
    private String isbn;
    private String autor;

    public Libro(String titulo, String isbn, String autor) {
        this.titulo = titulo;
        this.isbn = isbn;
        this.autor = autor;
    }

    public Libro() {
    }

    public void prestamo() {

    }

    public void devolucion() {

    }
    @Override
    public String toString() {
        return String.format("%s, %s, %s", this.titulo, this.isbn, this.autor);
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
}
