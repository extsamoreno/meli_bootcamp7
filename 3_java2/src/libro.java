public class libro {

    private String titulo;
    private long isbn;
    private String autor;

    public libro() {
    }

    public libro(String titulo, long isbn, String autor) {
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

    public long getIsbn() {
        return isbn;
    }

    public void setIsbn(long isbn) {
        this.isbn = isbn;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void pestamo(){}
    public void devolucion(){}

    @Override
    public String toString() {
        return "libro{" +
                "titulo='" + titulo + '\'' +
                ", isbn=" + isbn +
                ", autor='" + autor + '\'' +
                '}';
    }
}
