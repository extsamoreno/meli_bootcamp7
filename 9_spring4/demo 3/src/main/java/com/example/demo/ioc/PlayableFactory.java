package com.example.demo.ioc;

public class PlayableFactory {

    public enum kindOfPlay{PC, CONSOLE};

    public static IPlayable create(kindOfPlay kind){
        IPlayable playable;
        switch (kind){
            case PC:
                playable = new PC("windows");
                break;
            default:
                playable = new Console("ps5");
                break;
        }

        return playable;
    }
}
