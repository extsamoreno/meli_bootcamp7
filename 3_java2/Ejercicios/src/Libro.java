public class Libro {

    private String titulo;
    private int isbn;
    private String autor;
    private boolean prestado;

    // Constructores
    public Libro() {
    }

    public Libro(String titulo, int isbn, String autor, boolean prestado) {
        this.titulo = titulo;
        this.isbn = isbn;
        this.autor = autor;
        this.prestado = prestado;
    }

    // Metodos
    public void prestamo(){
        this.prestado = true;
    }

    public void devolucion(){
        this.prestado = false;
    }

    public String ToString(){

        String libro = this.titulo + ", " + this.isbn + ", " + this.autor;
        return libro;
    }


    // Getters y Setters
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public boolean isPrestado() {
        return prestado;
    }

    public void setPrestado(boolean prestado) {
        this.prestado = prestado;
    }
}
