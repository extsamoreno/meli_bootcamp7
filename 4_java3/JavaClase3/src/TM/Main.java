package TM;

public class Main {
    public static void main(String[] args) {
        Precedeable<Persona>[] arrPersonas = new Persona[5]; //dudas sobre como generar el arreglo
        arrPersonas[0] = new Persona("Juan", 33457383);
        arrPersonas[1] = new Persona("Ana", 33456459);
        arrPersonas[2] = new Persona("Daniel", 33456467);
        arrPersonas[3] = new Persona("María", 33456520);
        arrPersonas[4] = new Persona("Marta", 33456636);

        SortUtil.ordenar(arrPersonas);
        for (Precedeable<Persona> p :
                arrPersonas) {
            System.out.println(p);
        }

        Precedeable<Celular>[] arrCelulares = new Celular[5]; //dudas sobre como generar el arreglo
        arrCelulares[0] = new Celular("Juan", 33457383);
        arrCelulares[1] = new Celular("Ana", 33456459);
        arrCelulares[2] = new Celular("Daniel", 33456467);
        arrCelulares[3] = new Celular("María", 33456520);
        arrCelulares[4] = new Celular("Marta", 33456636);

        SortUtil.ordenar(arrCelulares);
        for (Precedeable<Celular> c : //se llama precedeable o persona???
                arrCelulares) {
            System.out.println(c);
        }
    }
}
