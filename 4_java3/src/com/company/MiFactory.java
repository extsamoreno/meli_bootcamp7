package com.company;

import java.io.*;
import java.util.*;

public class MiFactory {

    public static Object getInstance(String objName) throws IOException, ClassNotFoundException {
        FileReader reader = new FileReader("/Users/ctaeger/Desktop/RepoBootcampTaeger-Camila/meli_bootcamp7/4_java3/src/com/company/MiFactory.properties");
        Properties p = new Properties();
        p.load(reader);

        System.out.println(p.getProperty("sorter"));

        Class<?> newObj = Class.forName(p.getProperty("sorter"));
        return newObj;
    }
}
