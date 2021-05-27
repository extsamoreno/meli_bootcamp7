package com.meli;

class PasswordIntermedia extends password {

    private final String REGEX = "^(?=.*[0-9])(?=.*[a-z]).{8,20}$";

    public PasswordIntermedia() {
        super();
        this.setRegex(this.REGEX);
    }

}
