package com.meli;

public class Libro {

    private String titulo;
    private long isbn;
    private String autor;
    private boolean prestado;

    public Libro() {
        this.titulo = "";
        this.isbn = 0;
        this.autor = "";
        this.prestado = false;
    }

    public Libro(String titulo, long isbn, String autor, boolean prestado) {
        this.titulo = titulo;
        this.isbn = isbn;
        this.autor = autor;
        this.prestado = prestado;
    }

    public String prestamo() {

        if(this.prestado == false) {
            this.prestado = true;
            return "OK";
        }

        return "No se pudo realizar el prestamo";

    }

    public String devolucion() {

        if(this.prestado) {
            this.prestado = false;
            return "OK";
        }

        return "Este libro no esta prestado";

    }

    @Override
    public String toString() {
        return this.autor + ", " + this.isbn + ", " + this.titulo;
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

    public boolean isPrestado() {
        return prestado;
    }

    public void setPrestado(boolean prestado) {
        this.prestado = prestado;
    }

}
