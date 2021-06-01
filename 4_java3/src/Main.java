public class Main {
    public static void main(String[] args) {
        Persona persona1= new Persona("Pers1",111);
        Persona persona2= new Persona("Pers2",122);
        Persona persona3= new Persona("Pers3",123);
        Persona[] aPersonas = {persona1,persona2,persona3};
        SortUtil.ordenar(aPersonas);
        for (int i = 0; i < aPersonas.length; i++) {
            System.out.println(aPersonas[i].getDni());
        }
        Celular celular1= new Celular(521465,"Pers1");
        Celular celular2= new Celular(415684,"Pers2");
        Celular celular3= new Celular( 45641,"Pers3");
        Celular[] aCelular = {celular2,celular1,celular3};
        SortUtil.ordenar(aCelular);
        for (int i = 0; i < aCelular.length; i++) {
            System.out.println(aCelular[i].getCelular());
        }

    }
}
