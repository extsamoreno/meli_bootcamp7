public class Invitado {
    private String nombre,apellido, tag;

    public Invitado(String nombre, String apellido, String tag) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.tag = tag;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
