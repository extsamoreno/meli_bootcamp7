package Ejercicio2;

public class Contador {
    //Atriutos
    int numPosicion;

    //Constructores
    public  Contador(){
        this.numPosicion=0;
    }
    public Contador(int num){
        this.numPosicion=num;
    }
    public Contador(Contador cont){
        this.numPosicion=cont.numPosicion;

    }
    //getters y setters


    public int getNum() {
        return numPosicion;
    }

    public void setNum(int num) {
        this.numPosicion = num;
    }
    //metodos

    public void incrementar(){
        numPosicion++;
    }
    public void decrementar(){
        numPosicion--;
    }
    public void incrementar(int n){
        numPosicion+=n;
    }
    public void decrementar(int n){
        numPosicion-=n;
    }

    //toString

    @Override
    public String toString() {
        return "Contador{" +
                "numPosicion=" + numPosicion +
                '}';
    }
}



