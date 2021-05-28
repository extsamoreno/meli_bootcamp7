public class Libro {
    private String titulo;
    private String isbn;
    private String autor;

    public Libro() {
        this.titulo = "";
        this.isbn = "";
        this.autor = "";
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

    public void prestamo(){

    }
    public void devolucion(){

    }

    @Override
    // El método tostring no está en la clase padre por lo cual no puede ser sobre escrito
    public String toString() {
        return this.titulo+", "+this.isbn+", "+this.autor;

    }
}
