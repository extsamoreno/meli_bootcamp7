package com.company;

public class Libro {
    private String titulo,isbn,autor;
    private boolean onStock;


    public Libro(String titulo, String isbn, String autor, boolean onStock) {
        this.titulo = titulo;
        this.isbn = isbn;
        this.autor = autor;
        this.onStock = onStock;
    }

    public Libro() {
    }

    public void prestamo(){
        this.onStock=false;

    }
    public void devolucion(){
        this.onStock=true;

    }

    @Override
    public String toString() {
        return "Libro{" +
                "titulo='" + titulo + '\'' +
                ", isbn='" + isbn + '\'' +
                ", autor='" + autor + '\'' +
                ", onStock=" + onStock +
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

    public boolean isOnStock() {
        return onStock;
    }

    public void setOnStock(boolean onStock) {
        this.onStock = onStock;
    }
}
