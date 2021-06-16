package com.example.challenge_2.exception;

public class DistrictNotFoundException extends DistrictException {
    public DistrictNotFoundException(String name) {
        super("District with name: ".concat(name).concat(" don't exists"));
    }
}
