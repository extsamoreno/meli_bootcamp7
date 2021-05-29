public class Libro {
    private String titulo;
    private String isbn;
    private String autor;
    private boolean disponible;

    public Libro(String titulo, String isbn, String autor) {
        this.titulo = titulo;
        this.isbn = isbn;
        this.autor = autor;
        this.disponible = true;
    }
    @Override
    public String toString(){
        return titulo + ", " + isbn + ", " + autor + ".";
    }
    public void prestamo(){
        disponible = false;
    }

    public void devolución(){
        disponible = true;
    }

    public boolean isDisponible() {
        return disponible;
    }
}
