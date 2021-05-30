package TM;

public class Contador {
    private double contador;

    public Contador(){}

    public Contador(Contador contador){
        setContador(contador.contador);
    }
    public Contador(double num){
        setContador(num);
    }

    public void setContador(double num){
        this.contador = num;
    }

    public double getContador(){
        return(this.contador);
    }

    void inContador(){
        setContador(getContador()+1);
    }
    void deContador(){
        setContador(getContador()-1);
    }
}
