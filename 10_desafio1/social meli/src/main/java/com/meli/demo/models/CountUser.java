package com.meli.demo.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data@NoArgsConstructor@AllArgsConstructor
public class CountUser {

    private Integer userid;
    private String userName;
    private Integer followers_count;


}
