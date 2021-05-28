public class MainClass {
    public static void main(String[] args) {
        Persona[] lista= new Persona[6];
        lista[0]= new Persona("hola",1);
        lista[1]= new Persona("hola",3);
        lista[2]= new Persona("hola",5);
        lista[3]= new Persona("hola",2);
        lista[4]= new Persona("hola",6);
        lista[5]= new Persona("hola",4);

        System.out.println("\nAntes de ordenar: ");
        for (int i=0; i< lista.length;i++){
            System.out.print(lista[i].getDni()+" ");
        }
        System.out.println("\nDespues de ordenar: ");
        SortUtil.ordenar(lista);
        for (int i=0; i< lista.length;i++){
            System.out.print(lista[i].getDni()+" ");
        }

        Celular[] lista2= new Celular[6];
        lista2[0] = new Celular(1,"hola");
        lista2[1] = new Celular(3,"hola");
        lista2[2] = new Celular(5,"hola");
        lista2[3] = new Celular(2,"hola");
        lista2[4] = new Celular(6,"hola");
        lista2[5] = new Celular(4,"hola");
        System.out.println("\nAntes de ordenar: ");
        for (int i=0; i< lista2.length;i++){
            System.out.print(lista2[i].getNumero()+" ");
        }
        System.out.println("\nDespues de ordenar: ");
        SortUtil.ordenar(lista2);
        for (int i=0; i< lista2.length;i++){
            System.out.print(lista2[i].getNumero()+" ");
        }
    }
}
