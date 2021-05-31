package bootcamp;

import java.util.ArrayList;

public class Pack implements FuegoArtificialI {
    private final ArrayList<FuegoArtificialI> pack = new ArrayList<>();

    public void addFuego(FuegoArtificialI fuego){
        pack.add(fuego);
    }

    public void addPack(Pack pack) { this.pack.add(pack);}

    @Override
    public void explotar() {
        for(FuegoArtificialI fuego: pack) fuego.explotar();
    }



    //    public static ArrayList<FuegoArtificial> getFuegos(Pack packe) {
//        ArrayList<FuegoArtificial> fuegos = new ArrayList<>();
//
////        for(Object x: pack){
//        for(int i = 0; i < packe.size()){
//            if(x instanceof FuegoArtificial){
//                fuegos.add((FuegoArtificial) x);
//            }else{
//                ArrayList<FuegoArtificial> fuegos2 = getFuegos((Pack) x);
//                for( FuegoArtificial y: fuegos2){
//                    fuegos.add(y);
//                }
//            }
//        }
//    }


}
