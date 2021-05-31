package meli.ejerc;

public class Main {
    public static void main(String[] args) {
        /*Precedable<Persona> perJoven = FactoryPrecedable.generarPrecedable("Pablo", 45763283);
        Precedable<Persona> perVieja = FactoryPrecedable.generarPrecedable("Anastacio", 20473658);
        Precedable<Persona> perAdulta = FactoryPrecedable.generarPrecedable("Javier", 35637827);


        Precedable<Celular> celJoven = FactoryPrecedable.generarPrecedable(1783276, "Pablo");
        Precedable<Celular> celAdulto = FactoryPrecedable.generarPrecedable(1038723, "Javier");
        Precedable<Celular> celViejo = FactoryPrecedable.generarPrecedable(1, "Anastacio");

        Precedable[] preArray = new Precedable[3];
        preArray[0] = celJoven;
        preArray[1] = celViejo;
        preArray[2] = celAdulto;

        SortUtil.ordenar(preArray);

        for (Precedable precedable : preArray) {
            System.out.println(precedable.toString());
        }

        /*Persona perPri = new Persona("Pablo", 746582938);
        System.out.println("Persona creada: " + perPri.getNombre());
        Persona perSeg = new Persona("Juan", 746582939);
        System.out.println("Persona creada: " + perSeg.getNombre());

        System.out.println("Persona segunda precede a persona primera?: " + perPri.precedeA(perSeg));*/

    }
}
