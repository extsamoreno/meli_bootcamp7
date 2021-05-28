public class Celular implements Precedable<Celular>{
    
    private int año;
    private String numero;
    private String modelo;

    public Celular(int año, String numero, String modelo){

        this.modelo = modelo;
        this.numero = numero;
        this.año = año;
    }

    public int precedeA(Celular celular){

        return (this.año < celular.getAño()) ? 1 : 0;
    }

    public int getAño() {
        return año;
    }


    public void setAño(int año) {
        this.año = año;
    }


    public String getNumero() {
        return numero;
    }

 
    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getModelo() {
        return modelo;
    }


    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

}
