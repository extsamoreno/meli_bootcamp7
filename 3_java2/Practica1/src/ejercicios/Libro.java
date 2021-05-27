package ejercicios;

public class Libro {

    private String titulo;
    private String isbn;
    private String autor;
    private boolean disponible = true;

    public Libro() {
        this.titulo = "Rayuela";
        this.isbn = "isbn001";
        this.autor = "Julio Cortazar";
    }

    public Libro(String titulo, String isbn, String autor) {
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

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    @Override
    public String toString() {
        return titulo + "," + isbn + "," + autor;
    }

    public String prestamo(){
        if(disponible){
            this.disponible = false;
            return "Prestamo Aprobado";
        }
        else {
            return "Prestamo No Aprobado";
        }
    };

    public String devolucion(){
        if(!disponible){
            this.disponible = true;
            return "Libro devuelto";
        }
        else {
            return "Libro ya estaba";
        }
    };


}
