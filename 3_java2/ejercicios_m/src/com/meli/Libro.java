package com.meli;

public class Libro {
    private String titulo, autor, isbn;
    private boolean prestado;

    public Libro() {
    }

    public Libro(String titulo, String autor, String isbn, boolean prestado) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.prestado = prestado;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public boolean isPrestado() {
        return prestado;
    }

//    public void setPrestado(boolean prestado) {
//        this.prestado = prestado;
//    }

    public void prestamo() {
        if(!isPrestado()) {
            this.prestado = true;
        }
    }

    public void devolucion() {
        this.prestado = false;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "titulo='" + titulo + '\'' +
                ",isbn='" + isbn + '\'' +
                ",autor='" + autor + '\'' +
                '}';
    }
}
