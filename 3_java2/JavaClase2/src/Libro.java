public class Libro {

    private String titulo;
    private long isbn;
    private String autor;

    public Libro(){

    }

    public Libro(String titulo, long isbn, String autor){
        this.titulo = titulo;
        this.isbn = isbn;
        this.autor = autor;
    }


    public void prestamo(){}
    public void devolucion(){}

//    @Override
//    public String toString(){
//        return "Libro{" +
//                "titulo='" + this.titulo + '\' +
//                ", isbn='" + this.isbn + '\' +
//                ", autor='" + this.autor + '\' +
//                        "'}";
//
//    }
}
