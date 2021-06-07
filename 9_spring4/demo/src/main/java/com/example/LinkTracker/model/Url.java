package com.example.LinkTracker.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Optional;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Url {
    private String value;
    private Integer id;
    private Integer key_redirect;
    private Optional<String> password;
    private boolean available;


}
