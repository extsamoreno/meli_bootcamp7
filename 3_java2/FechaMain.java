public class FechaMain {
    public static void main(String[] args) throws Exception{
        try {
            Fecha fecha = new Fecha(5,5,2021);
            fecha.sumarDia(2);
            System.out.println(fecha);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }
}
