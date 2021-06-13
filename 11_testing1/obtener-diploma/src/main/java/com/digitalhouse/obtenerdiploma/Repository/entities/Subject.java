package com.digitalhouse.obtenerdiploma.Repository.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
public class Subject{
    private String subject;

    public String getSubject() {
        return this.subject;
    }
}
