public class Libro {
    private String title, writer, isbn;
    private boolean available;

    public Libro() {
    }

    public Libro(String title, String writer, String isbn, boolean available) {
        this.title = title;
        this.writer = writer;
        this.isbn = isbn;
        this.available = available;
    }

    public void prestamo() {
        this.available = false;
    }

    public void devolucion() {
        this.available = true;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public boolean isAvailable() {
        return available;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "title='" + title + '\'' +
                ", writer='" + writer + '\'' +
                ", isbn='" + isbn + '\'' +
                ", available=" + available +
                '}';
    }
}
