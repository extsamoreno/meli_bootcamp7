package mañana;

public class Libro {
    private String titulo;
    private String isbn;
    private String autor;

    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    //constructores
    public Libro(){}
    public Libro(String titulo, String isbn, String autor){
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
    }

    //metodos
    public void prestamo(){

    }

    public void devolucion(){

    }

    @Override //si pongo tostring tira error ya que no encuentra un método con ese nombre para hacer el override
    public String toString(){
        return titulo + ", " + isbn + ", " + autor;
    }






}
