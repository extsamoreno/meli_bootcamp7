package com.company.chiquiFest;

public class InvitadoMeli extends Invitado {
    private int nroEmpleado;

    public InvitadoMeli(int nroEmpleado, String name) {
        super(name);
        this.nroEmpleado = nroEmpleado;
    }

    @Override
    void comer() {
        System.out.println("Viva la Chiqui!!");
    }
}
