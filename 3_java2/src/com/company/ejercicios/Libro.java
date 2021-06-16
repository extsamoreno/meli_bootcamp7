package com.company.ejercicios;

public class Libro {

    private String titulo;
    private String isbn;
    private String autor;

    public Libro(String titulo, String isbn, String autor){
        this.titulo = titulo;
        this.isbn = isbn;
        this.autor = autor;
    }

    public Libro(Libro libro){
        libro.getAutor();
        libro.getIsbn();
        libro.getTitulo();
    }

    public Libro(){

    }

    public String prestamo(){
        return this.getTitulo() + "fue prestado";
    }

    public String devolucion(){
        return this.getTitulo() + "fue devuelto";
    }

    @Override
    public String toString() {
        return "Libro{" +
                "titulo='" + titulo + '\'' +
                ", isbn='" + isbn + '\'' +
                ", autor='" + autor + '\'' +
                '}';
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
