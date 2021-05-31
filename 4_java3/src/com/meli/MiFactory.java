package com.meli;

import java.io.InputStream;

public class MiFactory {
    private String propFileName;

    public MiFactory() {
        propFileName ="/MiFactory.propieties.txt";
        InputStream inputStream =getClass().getClassLoader().getResourceAsStream(propFileName);
        System.out.println(inputStream);
    }

    public MiFactory(String prop) {
        this.propFileName = prop;
    }

    public String getPropFileName() {
        return propFileName;
    }

    public void setPropFileName(String propFileName) {
        this.propFileName = propFileName;
    }

    public static Object getInstance(String objName){

        return new Object();
    }
}
