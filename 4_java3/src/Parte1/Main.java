package Parte1;

public class Main {
    public static void main(String[] args) {
        Persona p1 = new Persona();
        Persona p2 = new Persona();
        Persona p3 = new Persona();
        Persona p4 = new Persona();
        Persona p5 = new Persona();
        Persona p6 = new Persona();
        Persona p7 = new Persona();

        p1.setDni(4);
        p2.setDni(4);
        p3.setDni(8);
        p4.setDni(9);
        p5.setDni(1);
        p6.setDni(2);
        p7.setDni(3);

        Persona[] pArr = {p1, p2, p3, p4, p5, p6, p7};

        SortUtil.ordenar(pArr);
        for (Persona p:
             pArr) {
            System.out.println(p.getDni());
        }

        System.out.println("---- Telefonos ----");

        Tell t1 = new Tell();
        Tell t2 = new Tell();
        Tell t3 = new Tell();
        Tell t4 = new Tell();
        Tell t5 = new Tell();
        Tell t6 = new Tell();
        Tell t7 = new Tell();

        t1.setNum(1001);
        t2.setNum(1031);
        t3.setNum(1051);
        t4.setNum(1011);
        t5.setNum(1013);
        t6.setNum(1007);
        t7.setNum(1009);

        Tell[] tArr = {t1, t2, t3, t4, t5, t6, t7};
        SortUtil.ordenar(tArr);
        for (Tell t:
                tArr) {
            System.out.println(t.getNum());
        }

        p1.setName("Mariano");
        p2.setName("Macarena");
        p3.setName("Oliver");


        t1.setTitular("Nicoll");
        t2.setTitular("Alejandro");
        t3.setTitular("Jhon");

        System.out.println("---- Personas ----");

        SortUtil.ordenarString(pArr);
        for (Persona p:
                pArr) {
            System.out.println(p.getName());
        }

        System.out.println("---- Telefonos ----");
        SortUtil.ordenarString(tArr);
        for (Tell t:
                tArr) {
            System.out.println(t.getTitular());
        }
    }
}
