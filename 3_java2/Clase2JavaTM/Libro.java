package com.company.Clase2JavaTM;

public class Libro {

    private String titulo;
    private int isbn;
    private String autor;
    private boolean prestado;
    private boolean devuelto;
    public Libro() {
    }

    public Libro(String titulo, int isbn, String autor) {
        this.titulo = titulo;
        this.isbn = isbn;
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void prestamo() {
        if (this.prestado) {
            System.out.println("El libro no esta disponible. Ya se encuentra prestado");
        }else{
            this.prestado=true;
        }
    }

    public void devolucion(){
        if (!this.devuelto) {
            System.out.println("Usted ha devuelto el libro.");
        }else{
            this.devuelto=false;
        }
    }
    @Override
    public String toString(){
        String str;

        str = this.titulo+", "+String.valueOf(this.isbn)+", "+this.autor+", "+" Prestado: "+prestado
        +", Devuelto: "+devuelto;

        return str;
    }

    public static void main(String[] args) {
        Libro libro = new Libro("Cien años de soledad",1052010101,"Gabriel Garcia Marquez");

        System.out.println(libro.toString());

    }

}
