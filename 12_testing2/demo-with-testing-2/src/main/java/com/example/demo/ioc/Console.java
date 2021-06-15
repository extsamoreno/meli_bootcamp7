package com.example.demo.ioc;

import lombok.Getter;

@Getter
public class Console implements IPlayable{

    private String name;

    public Console(String name){
        this.name = name;
    }

    @Override
    public String play(){
        return "estoy jugando en: " + name;
    }
}
