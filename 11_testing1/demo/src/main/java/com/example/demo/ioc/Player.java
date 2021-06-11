package com.example.demo.ioc;

public class Player {

    private String name;
    private IPlayable playable;

    public Player(String name, IPlayable playable){
        this.name = name;
        playable = playable;
    }

    public void play(){
        System.out.println("Me llamo "+name+" y "+ playable.play() );
    }
}
