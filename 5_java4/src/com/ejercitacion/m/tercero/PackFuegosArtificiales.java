package com.ejercitacion.m.tercero;

import java.util.ArrayList;
import java.util.List;

public class PackFuegosArtificiales {

    private List<FuegoArtificial> fuegosArificiales;
    private List<PackFuegosArtificiales> packs;

    public PackFuegosArtificiales(List<FuegoArtificial> fuegosArificiales, List<PackFuegosArtificiales> packs) {
        this.fuegosArificiales = fuegosArificiales;
        this.packs = packs;
    }

    public PackFuegosArtificiales() {
        this.fuegosArificiales = new ArrayList<>();
        this.packs = new ArrayList<>();
    }

    public List<FuegoArtificial> getFuegosArificiales() {
        return fuegosArificiales;
    }

    public void setFuegosArificiales(List<FuegoArtificial> fuegosArificiales) {
        this.fuegosArificiales = fuegosArificiales;
    }

    public List<PackFuegosArtificiales> getPacks() {
        return packs;
    }

    public void setPacks(List<PackFuegosArtificiales> packs) {
        this.packs = packs;
    }
}
