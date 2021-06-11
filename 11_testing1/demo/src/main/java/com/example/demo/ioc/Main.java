package com.example.demo.ioc;

public class Main {

    public static void main(String[] args) {
        IPlayable iPlayable = PlayableFactory.create(PlayableFactory.kindOfPlay.PC);
        Player player = new Player("Santi", iPlayable);

        player.play();
    }
}
