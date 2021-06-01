package ejcio3_evento;

public abstract class Invitado {

    public String id;

    // Getters & Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    //Constructor
    public Invitado(String id) {
        this.id = id;
    }

    public abstract void comer();
}
