import java.util.Arrays;

public class FuegosArtificiales {
    public int id;
    public String sonido;
    public static int contador=0;

    public FuegosArtificiales() {
        this.id=contador;
        contador++;
        this.sonido=generarSonido();
    }

    private String generarSonido() {
        String[] x= {"Boom","Bam", "Pow","Cataplum", "Smash", "Fiuuuuu","Bang", "Bom", "Bing", "Hola"};
        String sonido="";
        for (int i = 0; i < Math.random()*x.length-1; i++) {
            sonido+=x[(int) Math.round((Math.random()*(x.length-1)))]+" ";
        }
        return sonido;
    }

    public void explotar(){
        System.out.println(sonido);
    }
}
