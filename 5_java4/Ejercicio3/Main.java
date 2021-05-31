import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        IFuegoArtifical f1 = new FuegoArtStandar("POOOOM !!");
        IFuegoArtifical f2 = new FuegoArtStandar("PAAAAA !!");
        IFuegoArtifical f3 = new FuegoArtStandar("PIIIIM !!");
        IFuegoArtifical f4 = new FuegoArtStandar("FIIIUM !!");
        IFuegoArtifical f5 = new FuegoArtStandar("PAAAAM !!");

        ArrayList<IFuegoArtifical> arr = new ArrayList<>();
        arr.add(f1);
        arr.add(f2);

        ArrayList<IFuegoArtifical> arr2 = new ArrayList<>();
        arr2.add(f3);
        arr2.add(f5);

        IFuegoArtifical pack1 = new FuegoArtPack(arr);
        IFuegoArtifical pack2 = new FuegoArtPack(arr2);

        ArrayList<IFuegoArtifical> arrFinal = new ArrayList<>();
        arrFinal.add(f1);
        arrFinal.add(f3);
        arrFinal.add(pack1);
        arrFinal.add(pack2);

        ArrayList<Invitado> arrInv = new ArrayList<>();
        Invitado inv1 = new Invitado("Carlos Gomez");
        Invitado inv2 = new InvitadoMeli("Lautaro Pozzolo MELI");
        arrInv.add(inv1);
        arrInv.add(inv2);

        Evento evento = new Evento(arrInv,arrFinal);
        evento.apagarVelas();
    }

    private static void printArray(Integer arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i){
            System.out.print(arr[i] + " ");
        }
    }
}
