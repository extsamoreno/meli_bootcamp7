package com.company;

public class Libro {
    private String título;
    private int isbn;
    private String autor;
    private String ubiacion;

    public Libro() {

    }

    public Libro(String título, int isbn, String autor, String ubiacion) {
        this.título = título;
        this.isbn = isbn;
        this.autor = autor;
        this.ubiacion = ubiacion;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTítulo() {
        return título;
    }

    public void setTítulo(String título) {
        this.título = título;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public String getUbiacion() {
        return ubiacion;
    }

    public void setUbiacion(String ubiacion) {
        this.ubiacion = ubiacion;
    }

    public void prestamo(String ubiacion) {
        this.ubiacion = ubiacion;
    }

    public void devolucion() {
        this.ubiacion = "Tienda";
    }

    @Override
    public String toString() {
        return "Libro{" +
                "título='" + título + '\'' +
                ", isbn=" + isbn +
                ", autor='" + autor + '\'' +
                ", ubiacion='" + ubiacion + '\'' +
                '}';
    //Si se le pone s minuscula indica error de que no esta sobreescribiendo una metodo de clase Objeto
    }
}
