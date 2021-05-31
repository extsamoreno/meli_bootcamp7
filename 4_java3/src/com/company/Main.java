package com.company;

import com.company.chiquiFest.*;
import com.company.exercises2.*;
import com.company.saveTheRopa.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Main {

    public static void main(String[] args) {

        List<Invitado> invitados = new ArrayList<>();
        invitados.add(new InvitadoMeli(1, "Jorge"));
        invitados.add(new InvitadoMeli(2, "Fabian"));
        invitados.add(new InvitadoMeli(3, "Edu"));
        invitados.add(new InvitadoStandard("Flor"));
        invitados.add(new InvitadoMeli(4, "Fran"));
        invitados.add(new InvitadoStandard("Bren"));
        invitados.add(new InvitadoStandard("Santiago"));
        invitados.add(new InvitadoMeli(5, "Sol"));

        List<Object> fuegosArticiales = new ArrayList<>();
        fuegosArticiales.add(new FuegoArtificial());

        List<Object> pack1 = new ArrayList<>();
        pack1.add(new FuegoArtificial());
        pack1.add(new FuegoArtificial());
        fuegosArticiales.add(pack1);

        List<Object> pack2 = new ArrayList<>();
        pack2.add(pack1);
        pack2.add(new FuegoArtificial());
        fuegosArticiales.add(pack2);

        Evento evento = new Evento(invitados, fuegosArticiales);

        evento.distribuirPorcionesDeTorta();
        evento.explotarFuegosArticiales();
    }

    public static void mainForSaveTheRopa() {
        GuardaRopa guardaRopa = new GuardaRopa();
        List<Prenda> prendas1 = new ArrayList<Prenda>();

        prendas1.add(new Camisa("Adidas", "L"));
        prendas1.add(new Campera("Nike", "M"));
        prendas1.add(new Remera("Gucci", "S"));

        List<Prenda> prendas2 = new ArrayList<Prenda>();
        prendas2.add(new Campera("Puma", "XL"));

        int nroGuardaRopa = guardaRopa.guardarPrendas(prendas1);

        System.out.println("Ropa guardada en casillero nro " + nroGuardaRopa);
        System.out.println("Ropa guardada en casillero nro " + guardaRopa.guardarPrendas(prendas2));

        guardaRopa.mostrarPrendas();

        List<Prenda> prendasDevueltas = guardaRopa.devolverPrendas(nroGuardaRopa);

        System.out.println("Prendas devueltas: ");
        guardaRopa.printArray(prendasDevueltas);
    }

    public static void Reflection() throws IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Integer[] arrNumbers = {10, 7, 8, 9, 1, 5};
        String[] arrNames = {"Jorge", "Fabian", "Eduardo", "Florencia", "Sofia"};

        FileReader reader = new FileReader("src/com/company/MiFactory.properties");
        Properties p = new Properties();
        p.load(reader);

        String nameObject = p.getProperty("sorter");

        Class<?> objectResult = (Class) MiFactory.getInstance(nameObject);

        Sorter<Integer> instanceIntResult = (Sorter<Integer>) objectResult.getConstructor().newInstance();
        instanceIntResult.sort(arrNumbers, (a, b) -> b - a);

        Sorter<String> instanceStringResult = (Sorter<String>) objectResult.getConstructor().newInstance();
        instanceStringResult.sort(arrNames, (a, b) -> a.compareTo(b));

        System.out.println(" Sorted array with " + objectResult.getSimpleName() + ": ");
        printArray(arrNumbers);
        printArray(arrNames);
    }

    public static <T> void printArray(T arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void testExercises() {
        Persona person3 = new Persona("Pers3", 333);
        Persona person2 = new Persona("Pers2", 122);
        Persona persona1 = new Persona("Pers1", 123);
        Persona[] aPersonas = {persona1, person2, person3};

        SortUtil.ordenar(aPersonas);

        for (int i = 0; i < aPersonas.length; i++) {
            System.out.println(aPersonas[i].getDni());
        }

        Celular celular1 = new Celular(1233, "A");
        Celular celular2 = new Celular(3333, "B");
        Celular celular3 = new Celular(2222, "C");
        Celular celular4 = new Celular(3242, "D");
        Celular[] aCelulares = {celular1, celular2, celular3, celular4};

        SortUtil.ordenar(aCelulares);
        for (int i = 0; i < aCelulares.length; i++) {
            System.out.println(aCelulares[i].getCelular());
        }
    }
}

