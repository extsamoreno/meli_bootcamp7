package com.company;

public class Contador {

    private int value;

    public Contador(int value){
        this.value = value;
    }

    public Contador(Contador contador){
        this.value = contador.getValue();
    }

    public Contador(){ }

    public int getValue(){
        return this.value;
    }

    public void setValue(int value){
        this.value = value;
    }

    public void increment(int value){
       this.value += value;
    }
    public void decrement(){
        this.value -= value;
    }

}
