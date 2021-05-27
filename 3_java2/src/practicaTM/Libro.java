package practicaTM;

public class Libro {

    private String titulo;
    private String isbn;
    private String autor;
    private boolean prestado;


    public Libro() {
    }

    public Libro(String titulo, String isbn, String autor, boolean prestado) {
        this.titulo = titulo;
        this.isbn = isbn;
        this.autor = autor;
        this.prestado = prestado;
    }

    public Libro(Libro libro) {
        this.titulo = libro.getTitulo();
        this.isbn = libro.getIsbn();
        this.autor = libro.getAutor();
        this.prestado = libro.getPrestado();
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

    public boolean getPrestado() {
        return prestado;
    }

    public void setPrestado(boolean prestado) {
        this.prestado = prestado;
    }

    public void prestamo() {
        if (!prestado) this.prestado = true;
    }

    public void devolucion() {
        if (prestado) this.prestado = false;
    }

    @Override
    public String toString() {
        return titulo + "," + isbn + ',' + autor;
    }
}
