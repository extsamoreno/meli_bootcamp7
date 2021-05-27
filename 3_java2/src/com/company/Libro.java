package com.company;

public class Libro {
    private String titulo;
    private String isbn;
    private String autor;
    private boolean prestado;

    public boolean isPrestado() {
        return prestado;
    }

    public void setPrestado(boolean prestado) {
        this.prestado = prestado;
    }

    public Libro() {
        prestado=false;
    }

    public Libro(String titulo, String isbn, String autor) {
        prestado=false;
        this.titulo = titulo;
        this.isbn = isbn;
        this.autor = autor;
    }

    public Libro(Libro copia) {
        this.titulo = copia.getTitulo();
        this.isbn = copia.getIsbn();
        this.autor = copia.getAutor();
        this.prestado=copia.isPrestado();
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

    public void prestamo(){
        prestado=true;
    }

    public void devolucion(){
        prestado=false;
    }

    @Override
    public String toString() {
        return "titulo='" + titulo +", isbn='" + isbn +", autor='" + autor;
    }
}
