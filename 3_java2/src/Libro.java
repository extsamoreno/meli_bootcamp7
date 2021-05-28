public class Libro {

    private String title;
    private long isbn;
    private String author;

    public Libro() {
    }

    public Libro(String title, long isbn, String author) {
        this.title = title;
        this.isbn = isbn;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public void prestamo() {
    }

    public void devolucion() {
    }

    @Override
    public String toString() {
        return "Libro{" +
                "titulo =" + this.title +
                ", isbn = " + this.isbn +
                ", autor = " + this.author + "}";
    }


}
