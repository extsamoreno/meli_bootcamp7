package ejercicio3;

public class Libro {
    private String titulo;
    private String isbn;
    private String author;
    private boolean prestado;

    public Libro(String titulo, String isbn, String author, boolean prestado) {
        this.titulo = titulo;
        this.isbn = isbn;
        this.author = author;
        this.prestado= prestado;
    }

    public Libro() {
        this.titulo = "Harry Potter";
        this.isbn = "9780545582889";
        this.author = "J.K. Rowling";
        this.prestado = true;
    }

    public Libro(Libro libro){
        this.titulo = libro.getTitulo();
        this.isbn = libro.getIsbn();
        this.author = libro.getAuthor();
        this.prestado= libro.getPrestado();
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
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean getPrestado(){
        return prestado;
    }

    public void setPrestado(boolean prestado) {
        this.prestado = prestado;
    }

    public boolean estaPrestado() {
        return prestado;
    }

    public void prestamo(){
        this.prestado = true;
    }

    public void devolucion(){
        this.prestado = false;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "titulo='" + titulo + '\'' +
                ", isbn='" + isbn + '\'' +
                ", author='" + author + '\'' +
                ", prestado=" + prestado +
                '}';
    }
}