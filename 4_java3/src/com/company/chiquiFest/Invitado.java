package com.company.chiquiFest;

public abstract class Invitado {
    private String name;

    public Invitado(String name) {
        this.name = name;
    }

    abstract void comer();
}

