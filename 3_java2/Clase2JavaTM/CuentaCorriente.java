package com.company.Clase2JavaTM;

public class CuentaCorriente {

    private double saldo;

    public CuentaCorriente(){
    }

    public CuentaCorriente(double saldo){
        this.saldo=saldo;
    }

    public CuentaCorriente(CuentaCorriente cc){
         this.saldo =cc.saldo;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void ingreso(double monto){
        this.saldo+=monto;
    }
    public void egreso(double monto){

        if(monto>this.saldo){
            System.out.println("No tiene saldo suficiente");
        }else{
            this.saldo-=monto;
        }

    }
    public void reintegro(double monto){
        this.saldo+=monto;
    }
    public void transferencia(CuentaCorriente cc, double monto){

        if(monto>this.saldo){
            System.out.println("No tiene saldo suficiente");
        }else{
            this.saldo-=monto;
            cc.ingreso(monto);
        }
    }



    public static void main(String[] args) {
        CuentaCorriente c1= new CuentaCorriente(600);
        CuentaCorriente c2 = new CuentaCorriente(1000);

        c1.transferencia(c2,600);

        System.out.println(c1.saldo);
        System.out.println(c2.saldo);
    }
}

