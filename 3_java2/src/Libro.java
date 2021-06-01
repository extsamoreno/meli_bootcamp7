public class Libro {

    private String titulo;
    private Long isbn;
    private String autor;
    private boolean prestamos;

    public Libro() {
    }

    public Libro(String titulo, Long isbn, String autor, boolean prestamos) {
        this.titulo = titulo;
        this.isbn = isbn;
        this.autor = autor;
        this.prestamos = prestamos;
    }

    public Libro(Libro libro) {
        this.titulo = libro.getTitulo();
        this.isbn = libro.getIsbn();
        this.autor = libro.getAutor();
        this.prestamos = libro.isPrestamos();
    }

    public void prestamo(){
        if(this.prestamos)
            System.out.println("Ya esta prestado");
        else
            prestamos = true;
    }

    public void devolucion(){
        if(!this.prestamos)
            System.out.println("Ya esta devuelto");
        else
            prestamos = false;
    }

    @Override
    public String toString(){
        return this.titulo + ", " + this.isbn + ", " + this.autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Long getIsbn() {
        return isbn;
    }

    public void setIsbn(Long isbn) {
        this.isbn = isbn;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public boolean isPrestamos() {
        return prestamos;
    }

    public void setPrestamos(boolean prestamos) {
        this.prestamos = prestamos;
    }

    public static void main(String[] args) {
        Libro libro = new Libro("Yo, Robot", 1357924680L, "Asimov, Isaac",false);

        System.out.println(libro.toString());
    }
}
