package com.ejercicioMañana;
//Crea una clase Libro con los métodos: préstamo, devolución y toString, cuyo prototipo debe ser: public String toString(). Este método debe retornar una cadena que represente al objeto. Por ejemplo: si la clase tiene los atributos: título, isbn y autor, una cadena que represente a un libro podría ser: “Harry Potter, 9780545582889, Rowling, J. K.”. La clase contendrá un constructor por defecto, un constructor con parámetros y los métodos de acceso.
//● Agregar la línea @Override justo arriba del encabezado del método toString. Luego, cambiar el nombre del método por: tostring (todo en minúscula). ¿Qué sucede?

public class Libro {
    private String titulo;
    private String isbn;
    private String autor;
    private String owner;
    private String holder;

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
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

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Libro(){

    }

    public Libro(String titulo, String isbn, String autor, String owner, String holder) {
        this.titulo = titulo;
        this.isbn = isbn;
        this.autor = autor;
        this.owner = owner;
        this.holder = holder;
    }

    public void prestamo(String nombrePersona){
        this.holder = nombrePersona;
    }

    public void devolucion(){
        this.holder = this.owner;
    }

    @Override
    public String toString(){
        return "Autor: " + this.autor + ", ISBN: " + this.isbn + ", Dueño: " + this.owner;
    }


}
