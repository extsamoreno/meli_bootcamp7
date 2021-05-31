package Exercise3;

public abstract class Invitado {
    private String id;
    public abstract void comer();
    public Invitado(String id){
        this.id = id;
    }
}
