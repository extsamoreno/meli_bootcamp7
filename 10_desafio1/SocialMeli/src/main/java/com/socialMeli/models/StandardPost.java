package com.socialMeli.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StandardPost extends Post{

    private Product detail;

    @Override
    public Product getDetail(){
        return this.detail;
    }
}
