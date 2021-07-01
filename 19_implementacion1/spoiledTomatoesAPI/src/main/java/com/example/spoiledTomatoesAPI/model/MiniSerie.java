package com.example.spoiledTomatoesAPI.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class MiniSerie {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Double rating;
    private Integer awards;
}
