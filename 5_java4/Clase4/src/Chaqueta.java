public class Chaqueta extends Prenda{
    
    public Chaqueta(String marca, String modelo){

        this.setTipo(Prenda.CHAQUETA);
        this.setMarca(marca);
        this.setModelo(modelo);

    }

    @Override
    public String toString(){

        return "tipo: "+this.getTipo()+ ", modelo: "+this.getModelo()+", marca: "+this.getMarca();
    };
}
