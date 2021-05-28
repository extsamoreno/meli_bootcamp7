public class Libro {
    private String titulo;
    private long isbn;
    private String autor;
    private boolean estado;

    public Libro(){
        this.titulo = "";
        this.isbn = 0;
        this.autor = "";
        this.estado = false;
    }

    public Libro(String titulo, long isbn, String autor) {
        this.titulo = titulo;
        this.isbn = isbn;
        this.autor = autor;
        this.estado = true;
    }

    public Libro(Libro lib){
        this.titulo = lib.titulo;
        this.isbn = lib.isbn;
        this.autor = lib.autor;
        this.estado = lib.estado;
    }

    String prestamo(){
        if(this.estado){
            this.estado = false;
            return "OK";
        }

        return "El libro no esta disponible para prestar";
    }

    String devolucion(){
        if(this.estado){
            this.estado = false;
            return "OK";
        }

        return "El libro no esta en posesion";
    }

    @Override
    public String toString(){
        return ""+titulo+", "+isbn+", "+autor;
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

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
