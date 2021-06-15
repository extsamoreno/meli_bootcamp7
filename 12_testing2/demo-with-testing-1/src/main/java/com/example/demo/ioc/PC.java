package com.example.demo.ioc;

public class PC implements IPlayable {

    private String os;

    public PC(String os){
        this.os = os;
    }

    @Override
    public String play(){
        return "estoy jugando en: " + os;
    }
}
