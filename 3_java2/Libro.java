public class Libro
{
    private String titulo;
    private Long isbn;
    private String autor;
    boolean prestado;

    public static void main(String[] args) {
        Libro lib = new Libro("Señor de los Anillos", 123456789, "Tolkien", false);

        lib.prestamo();
        lib.devolucion();

        String msg = lib.toString();

        System.out.println(msg);
    }

    //region Constructor
    public Libro(){}

    public Libro(String titulo, long isbn, String autor, boolean prestado)
    {
        this.titulo = titulo;
        this.isbn = isbn;
        this.autor = autor;
        this.prestado = prestado;
    }
    //endregion

    //region Methods
    public void prestamo()
    {
        if (!this.prestado)
            this.prestado = true;
    }

    public void devolucion()
    {
        this.prestado = false;
    }

    public String toString()
    {
        return this.titulo + " " + this.isbn + " " + this.autor + " Prestado: " + this.prestado;
    }

    //endregion
}
