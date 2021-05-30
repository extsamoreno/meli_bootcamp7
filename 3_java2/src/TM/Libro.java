package TM;

public class Libro {

    private boolean status;
    private String titulo;
    private String isbn;
    private String autor;


    public Libro(){

    }

    public Libro(String titulo, String isbm, String autor, boolean status){
        this.titulo = titulo;
        this.isbn = isbm;
        this.autor = autor;
        this.status = status;
    }

    private void prestamo(){
        setStatus(false);
    }

    private void devolucion(){
        setStatus(true);
    }

    @Override
    public String toString(){
        return (this.titulo + ',' + this.isbn + ',' + this.autor);
    }

    public void setStatus(boolean status){
        this.status = status;
    }
    public boolean getStatus(){
        return this.status;
    }
}
