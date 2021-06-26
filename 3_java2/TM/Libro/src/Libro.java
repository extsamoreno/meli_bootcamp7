public class Libro {
    private String titulo, isbn, autor;
    private boolean disponible;

    public Libro (String titulo, String isbn, String autor, boolean disponible) {
        this.titulo = titulo;
        this.isbn = isbn;
        this.autor = autor;
        this.disponible = disponible;
    }

    // getters
    public String obtenerTitulo () {
        return titulo;
    }

    public String obtenerIsbn () {
        return isbn;
    }

    public String obtenerAutor () {
        return autor;
    }

    // setters
    public void establecerTitulo (String titulo) {
        this.titulo = titulo;
    }

    public void establecerIsbn (String isbn) {
        this.isbn = isbn;
    }

    public void establecerAutor (String autor) {
        this.autor = autor;
    }

    // métodos de clase
    public void prestamo () {
        disponible = false;
    }

    public void devolucion () {
        disponible = true;
    }

    // sobre-escritura
    @Override
    public String toString() {
        return "Libro{" +
                "titulo='" + titulo + '\'' +
                ", isbn='" + isbn + '\'' +
                ", autor='" + autor + '\'' +
                ", disponible=" + disponible +
                '}';
    }
}