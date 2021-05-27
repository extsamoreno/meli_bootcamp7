public class Libro {

    private String titulo;
    private long isbn;
    private String autor;

    //contructor con parametros
    public Libro(String titulo, long isbn, String autor) {
        this.titulo = titulo;
        this.isbn = isbn;
        this.autor = autor;
    }

    //contructor por defecto
    public Libro() {
    }


    //get and set
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

    //metodos
    public void prestamo() {
    }

    public void devolucion() {
    }

    @Override
    public String toString() {
        return "Libro{" +
                "titulo='" + titulo + '\'' +
                ", isbn=" + isbn +
                ", autor='" + autor + '\'' +
                '}';
    }
    //si cambio el tostring a minuscula no se peude sobreescribir en el padre porque deja de ser
    //un metodo heredado y se convierte en un metodo distinto
}
