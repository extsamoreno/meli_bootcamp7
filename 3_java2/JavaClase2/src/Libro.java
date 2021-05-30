public class Libro {

    private String titulo;
    private long isbn;
    private String autor;

    public Libro(){

    }

    public Libro(String titulo, long isbn, String autor){
        this.setTitulo(titulo);
        this.setIsbn(isbn);
        this.setAutor(autor);
    }


    public void prestamo(){}
    public void devolucion(){}

    @Override
    public String toString(){
        return "Libro{ titulo= '" + this.titulo +
                "', isbn= '" + this.isbn +
                "', autor= '" + this.autor + "'}";
    }

    public String getTitulo() {
        return titulo;
    }

    public long getIsbn() {
        return isbn;
    }

    public String getAutor() {
        return autor;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setIsbn(long isbn) {
        this.isbn = isbn;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
}
