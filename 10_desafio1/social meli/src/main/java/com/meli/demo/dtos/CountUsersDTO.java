package com.meli.demo.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CountUsersDTO {

    private Integer userid;
    private String userName;
    private Integer followers_count;
}
