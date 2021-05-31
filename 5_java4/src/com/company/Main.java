package com.company;

import com.company.ej1.*;
import com.company.ej2.*;
import com.company.ej3.*;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        // EJERCICIO 1

        //  Crear en la clase Main un escenario en el cual alguien guarde dos prendas,
        //  reciba el código y luego reclame sus prendas

        /*
        Prenda p1 = new Campera("nike", "a101", "L");
        Prenda p2 = new Remera("moha", "c1b01", "XL");
        Prenda p3 = new Pantalon("adidas", "0x1S12", 40);
        List<Prenda> prendas = new ArrayList<>();
        List<Prenda> devolucion;
        GuardarRopa keeper = new GuardarRopa();
        int ticket;

        prendas.add(p1);
        prendas.add(p2);
        prendas.add(p3);

        ticket = keeper.guardarPrendas(prendas);
        keeper.mostrarPrendas();

        devolucion = keeper.devolverPrendas(ticket);
        System.out.println("==Quedan en guardaropa:");
        keeper.mostrarPrendas();

        System.out.println("--Saco:");

        for (Prenda p : devolucion) {
            System.out.println(p.toString());
        }
        */

        // EJERCICIO 2
        /*
        Carrera carrera = new Carrera(1000, 150000, "Dos Puentes",
                3, new SocorristaAuto(), new SocorristaMoto());
        carrera.darDeAltaAuto(100, 2, 50, "APX123");
        carrera.darDeAltaAuto(200, 2.5, 45.5, "APX234");
        carrera.darDeAltaMoto(150, 3, 10, "APX345");
        carrera.darDeAltaMoto(100, 1, 90, "APX456");
        carrera.darDeAltaAuto(300, 5.2, 100.5, "APX999");
        carrera.eliminarVehiculo(new Auto(200, 2.5, 45.5, "APX234"));
        carrera.eliminarVehiculoConPatente("APX123");
        carrera.darDeAltaAuto(100, 2, 50, "APX123");
        carrera.darDeAltaAuto(200, 2.5, 45.5, "APX234");

        carrera.socorrerAuto("APX123");
        carrera.socorrerAuto("APX345");
        carrera.socorrerMoto("APX123");
        carrera.socorrerMoto("APX345");

        Vehiculo ganador = carrera.definirGanador();
        System.out.println(ganador);
        */

        // EJERCICIO 3

        List<Invitado> invitados = new ArrayList<>();
        Invitado inv1 = new InvitadoMeli();
        Invitado inv2 = new InvitadoMeli();
        Invitado inv3 = new InvitadoStandard();
        Invitado inv4 = new InvitadoStandard();
        invitados.add(inv1);
        invitados.add(inv2);
        invitados.add(inv3);
        invitados.add(inv4);

        List<Component> fuegos = new ArrayList<>();
        fuegos.add(new FuegoArtificial("BOOM!"));
        fuegos.add(new FuegoArtificial("kaBuM!"));
        FuegoArtificial f1 = new FuegoArtificial("zaaBOOM!");
        FuegoArtificial f2 = new FuegoArtificial("!!poww!!");
        PackDeFuegos f4 = new PackDeFuegos();
        f4.add(f1);
        f4.add(f2);
        PackDeFuegos pack = new PackDeFuegos();
        pack.add(f4);
        pack.add(new FuegoArtificial("es el ultimo fiuuuuuuuu!"));
        fuegos.add(pack);

        Evento event = new Evento(invitados, fuegos);

        event.horaDeLaTorta();
    }
}
