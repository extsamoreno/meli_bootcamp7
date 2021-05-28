public class Libro {

    private String titulo, isbn, autor;
    private boolean enStock;

    public Libro (String titulo, String isbn, String autor, boolean enStock) {
        this.titulo = titulo;
        this.isbn = isbn;
        this.autor = autor;
        this.enStock = enStock;
    }

    public Libro () {}

    public void prestamo () {
        this.enStock = false;
    }

    public void devolucion () {
        this.enStock = false;
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

    public Boolean getEnStock() {
        return enStock;
    }

    public void setEnStock(Boolean enStock) {
        this.enStock = enStock;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "titulo='" + titulo + '\'' +
                ", isbn='" + isbn + '\'' +
                ", autor='" + autor + '\'' +
                ", enStock=" + enStock +
                '}';
    }
}
