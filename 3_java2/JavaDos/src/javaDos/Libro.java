package javaDos;

public class Libro {
    private String titulo;
    private long isbn;
    private String author;
    private boolean lended;

    public Libro () {
        this.titulo = "";
        this.isbn = 0;
        this.author = "";
        this.lended = false;
    }

    public Libro (String titulo, long isbn, String author) {
        this.titulo = titulo;
        this.isbn = isbn;
        this.author = author;
        this.lended = false;
    }

    public String prestamo() {
        if (!this.lended) {
            this.lended = true;
            return "Préstamo realizado";
        }
        return "No hay disponibilidad del libro solicitado";
    }

    public String devolucion() {
        if (this.lended) {
            this.lended = false;
            return "Devolución realizada";
        }
        return "No tiene este libro en posesión";
    }

    @Override //Todas las clases se heredan de object y object tiene un método toString
    public String toString(){
        return this.author + ", " + this.isbn + ", " + this.titulo;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean isLended() {
        return lended;
    }

    public void setLended(boolean lended) {
        this.lended = lended;
    }
}
