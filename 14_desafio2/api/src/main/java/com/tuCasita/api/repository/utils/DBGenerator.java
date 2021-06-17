package com.tuCasita.api.repository.utils;

import java.util.HashSet;

public class DBGenerator {
    public static HashSet<String> loadDistricts(){
        HashSet<String> districtNames = new HashSet<>();

        districtNames.add("High mountains");
        districtNames.add("Low mountains");
        districtNames.add("Riverside");
        districtNames.add("Manhattan");
        districtNames.add("Smallville");

        return districtNames;
    }
}
