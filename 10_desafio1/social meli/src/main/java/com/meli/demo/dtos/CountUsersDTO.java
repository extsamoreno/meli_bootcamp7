package com.meli.demo.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CountUsersDTO {

    private Integer userid;
    private String userName;
    private Integer followers_count;

    public CountUsersDTO(Integer userid, String userName, Integer followers_count) {
        this.userid = userid;
        this.userName = userName;
        this.followers_count = followers_count;
    }
}
