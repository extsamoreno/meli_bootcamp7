package com.company;

public class Libro {

    private String titulo;
    private String isbn;
    private String autor;
    private boolean status;

    public Libro() {
        this.titulo = "";
        this.isbn = "";
        this.autor = "";
    }

    public Libro(String titulo, String isbn, String autor) {
        this.titulo = titulo;
        this.isbn = isbn;
        this.autor = autor;
    }

    public Libro(Libro libro) {
        this.titulo = libro.getTitulo();
        this.isbn = libro.getIsbn();
        this.autor = libro.getAutor();
    }

    public void prestamo(){
        this.status = false;
    }

    public void devolucion(){
        this.status = true;
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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "titulo='" + titulo + '\'' +
                ", isbn='" + isbn + '\'' +
                ", autor='" + autor + '\'' +
                '}';
    }
}
