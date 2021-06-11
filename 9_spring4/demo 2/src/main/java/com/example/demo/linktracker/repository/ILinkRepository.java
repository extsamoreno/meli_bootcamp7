package com.example.demo.linktracker.repository;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
@Repository
public interface ILinkRepository {
    int getLinkId(String url);
    String getLink (int linkId);
}
