package practicaTM;

public class Main {
    public static void main(String[] args) {
        Persona p1 = new Persona("tavo1", 4);
        Persona p2 = new Persona("tavo2", 1);
        Persona p3 = new Persona("tavo3", 2);

        Precedable<Persona> arr1[]= new Precedable[3];
        arr1[0]=p1;
        arr1[1]=p2;
        arr1[2]=p3;

        SortUtil.ordenar(arr1);

        for (int i = 0; i < arr1.length; i++) {
            System.out.print(arr1[i].toString() + "\n");
        }


    }
}
