package com.company;

public class Libro {

    //Properties
    private String titulo;
    private String isbn;
    private String autor;
    private boolean prestado; //Si está prestado, es porque no está devuelto y si está devuelto, es porque no está prestado
    //Otra manera capaz, seria tener las dos propiedades, pero manejar dentro de los getters y setters esa logica.

    //Getters y setters
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

    public boolean isPrestado() {
        return prestado;
    }

    public void setPrestado(boolean prestado) {
        this.prestado = prestado;
    }

    //Para manejar un estado solo, me parece que puede quedar implicito, si hacemos lo contrario. Preguntar al profe igual
    public boolean isDevuelto() {
        return !prestado;
    }

    public void setDevuelto(boolean devuelto) {
        this.prestado = !devuelto;
    }

    //Contructores
    public Libro() { }

    public Libro(String titulo, String isbn, String autor) {
        this.titulo = titulo;
        this.isbn = isbn;
        this.autor = autor;
    }

    public Libro(Libro libroCopia) {
        this.titulo = libroCopia.getTitulo();
        this.autor = libroCopia.getAutor();
        this.isbn = libroCopia.isbn;
        this.prestado = libroCopia.prestado;
    }

    //Metodos
    public void prestamo() {
        this.setPrestado(true);
    }

    public void devuelto() {
        this.setDevuelto(true);
    }

    //Si ponemos minuscula, no nos deja tirar el override, porque ese metodo no existe en la clase padre
    @Override
    public String toString() {
        char splitter = ',';
        return getTitulo() + splitter + getIsbn() + splitter + getAutor();
    }

}
