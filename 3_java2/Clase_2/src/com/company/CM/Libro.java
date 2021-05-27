package com.company.CM;

public class Libro {


  /*  ● Crea una clase Libro con los métodos: préstamo, devolución y toString, cuyo prototipo debe ser: public String toString().
  Este método debe retornar una cadena que represente al objeto. Por ejemplo: si la clase tiene los atributos: título, isbn y autor, una cadena que represente a un
  libro podría ser: “Harry Potter, 9780545582889, Rowling, J. K.”. La clase contendrá un constructor por defecto, un constructor con parámetros y los métodos de acceso.
● Agregar la línea @Override justo arriba del encabezado del método toString. Luego, cambiar el nombre del método por: tostring (todo en minúscula). ¿Qué sucede?*/

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
