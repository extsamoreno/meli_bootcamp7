package com.company;

public class checkingAccount {

    private double saldo;
    private int accountNumber;

    public checkingAccount(double saldo, int account){
        this.saldo = saldo;
        this.accountNumber = account;
    }

    public checkingAccount(checkingAccount ctacte){
         this.saldo = ctacte.getSaldo();
         this.accountNumber = ctacte.getAccountNumber();
    }

    public checkingAccount(){
    }

    private void ingreso(double monto){
    }

    private void egreso(double monto){
    }

    private void reingreso(double monto){
    }

    private void transferencia(checkingAccount account, double monto){
    }

    public double getSaldo(){
        return this.saldo;
    }

    public void setSaldo(double saldo){
        this.saldo = saldo;
    }

    public int getAccountNumber(){
        return this.accountNumber;
    }

    public void setAccountNumber(int accountNumber){
        this.accountNumber = accountNumber;
    }

}
