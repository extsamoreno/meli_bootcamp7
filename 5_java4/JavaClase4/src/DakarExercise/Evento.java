package DakarExercise;

public interface Evento<T> {
    <T> void altaAuto(int v, int a, int aG, String p);
    <T> void altaMoto(int v, int a, int aG, String p);
    <T> void altaV(int v, int a, int aG, String p);
    <T> void eliminarVehiculo();
    <T> void eliminarVehiculoPatente();

}
