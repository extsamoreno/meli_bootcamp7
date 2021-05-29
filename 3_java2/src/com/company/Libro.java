package com.company;

public class Libro {

    private String title;
    private long isbn;
    private String author;


    public Libro(String title, long isbn, String author) {
        this.title = title;
        this.isbn = isbn;
        this.author = author;
    }

    public Libro(Libro book) {
        this.title = book.getTitle();
        this.author = book.getAuthor();
        this.isbn = book.getIsbn();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getIsbn() {
        return isbn;
    }

    public void setIsbn(long isbn) {
        this.isbn = isbn;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void prestamo() {
    }

    public void devolucion() {
    }

    public String tostring() {
        return "Libro{" +
                "title='" + title + '\'' +
                ", isbn=" + isbn +
                ", author=" + author +
                '}';
    }
}
