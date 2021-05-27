package com.company;

public class Libro {
    private String titulo;
    private String isbn;
    private String autor;

    public boolean getEstaPrestado() {
        return estaPrestado;
    }

    public void setEstaPrestado(boolean estaPrestado) {
        this.estaPrestado = estaPrestado;
    }

    public boolean getEstaDevuelto() {
        return estaDevuelto;
    }

    public void setEstaDevuelto(boolean estaDevuelto) {
        this.estaDevuelto = estaDevuelto;
    }

    private boolean estaPrestado;
    private boolean estaDevuelto;

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

    public Libro(){

    }
    public Libro(String titulo, String isbn, String autor, boolean estaDevuelto, boolean estaPrestado){
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.estaDevuelto = estaDevuelto;
        this.estaPrestado = estaPrestado;
    }
    public Libro(Libro libro){
        this.titulo = libro.titulo;
        this.autor = libro.autor;
        this.isbn = libro.isbn;
        this.estaDevuelto = libro.estaDevuelto;
        this.estaPrestado = libro.estaPrestado;
    }

    public void prestamo(){
        this.estaPrestado = true;
        this.estaDevuelto = false;
    }
    public void devolucion(){
        this.estaDevuelto = true;
        this.estaPrestado = false;
    }

    @Override
    public String toString(){
        return this.titulo + "," + this.isbn + "," + this.autor + ".";
    }

}
