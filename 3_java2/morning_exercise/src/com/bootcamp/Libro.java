package com.bootcamp;

public class Libro {
    private String titulo;
    private String isbn;
    private String autor;
    private boolean prestado;

    public Libro() {
    }

    public Libro(String titulo, String isbn, String autor) {
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

    private boolean isPrestado() {
        return prestado;
    }

    private void setPrestado(boolean prestado) {
        this.prestado = prestado;
    }

    //Si el libro no está prestado, lo puedo prestar, y el método prestado() nos
    //retornará un true. En caso contrario, nos retornará un false.
    public boolean prestamo() {
        if (!isPrestado()) {
            this.setPrestado(true);
            return true;
        }

        return false;
    }


    public boolean devolucion() {
        if (this.isPrestado()) {
            this.setPrestado(false);
            return true;
        }

        return false;
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
