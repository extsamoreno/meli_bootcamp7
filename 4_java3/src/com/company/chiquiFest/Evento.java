package com.company.chiquiFest;

import java.util.Collection;
import java.util.List;

public class Evento {
    private List<Invitado> invitadoList;
    private List<Object> packFuegosArticialesList;

    public Evento(List<Invitado> invitadoList, List<Object> packFuegosArticialesList) {
        this.invitadoList = invitadoList;
        this.packFuegosArticialesList = packFuegosArticialesList;
    }

    public void explotarFuegosArticiales() {
        explotarFuegosArticialesRecursivo(this.packFuegosArticialesList);
    }

    private void explotarFuegosArticialesRecursivo(List<Object> lstObjects) {
        for (Object unidad: lstObjects) {
            if (unidad instanceof Collection<?>) {
                explotarFuegosArticialesRecursivo((List<Object>) unidad);
            } else {
                System.out.println(unidad.toString());
            }
        }
    }

    public void distribuirPorcionesDeTorta() {
        for (Invitado invitado : invitadoList) {
            invitado.comer();
        }
    }
}
