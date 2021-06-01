package ejercicio3;

public class Invitados {

    private String nombre;
    private int tipo;

    public Invitados(String nombre, int tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
    }

    public void gritar(){
        if(tipo == TipoInvitado.Meli.ordinal()){
            System.out.println(nombre + ": Viva la Chiqui!!!");
        }
        else if(tipo == TipoInvitado.Standard.ordinal()){
            System.out.println(nombre + ": Muy buena la torta!");
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
}