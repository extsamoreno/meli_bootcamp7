public class Libro {
    private String titulo;
    private int ISBN;
    private String autor;
    private String estado;

    public Libro() {
    }

    public Libro(String titulo, int ISBN, String autor) {
        this.titulo = titulo;
        this.ISBN = ISBN;
        this.autor = autor;
        this.estado = "Disponible";
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void prestamo(){
        this.estado = "Prestado";
    }

    public void devolucion(){
        this.estado = "Disponible";
    }

    @Override
    public String toString() {
        return "" +
                "titulo='" + titulo + '\'' +
                ", ISBN=" + ISBN +
                ", autor='" + autor + '\'';
    }
}
