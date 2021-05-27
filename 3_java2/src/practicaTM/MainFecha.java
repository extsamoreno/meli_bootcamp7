package practicaTM;

public class MainFecha {
    public static void main(String[] args) {
        Fecha fecha1=new Fecha();
        Fecha fecha2=new Fecha(4,1,2022);

        System.out.println(fecha1);
        System.out.println(fecha1.getFecha());
        System.out.println(fecha2);

        String s1="hola";
        String s2="      1213hola";
        String s3="hola1        ";
        String s4="l234l678l0l";

        System.out.println(StringUtil.lTrim(s1));
        System.out.println(StringUtil.lTrim(s2));
        System.out.println(StringUtil.rTrim(s3));
        System.out.println(StringUtil.indexOfN(s4,'l',4));

    }
}
