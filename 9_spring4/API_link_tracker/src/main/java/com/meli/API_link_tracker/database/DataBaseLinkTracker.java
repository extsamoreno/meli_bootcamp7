package com.meli.API_link_tracker.database;

import com.meli.API_link_tracker.model.dao.model.Link;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class DataBaseLinkTracker {
    public static HashMap<Integer, Link> dataBase = new HashMap<>();
}
