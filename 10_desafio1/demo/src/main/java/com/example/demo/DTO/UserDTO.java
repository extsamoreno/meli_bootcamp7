package com.example.demo.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO implements Comparable{

    private Integer userId;
    private String userName;

    @Override
    public int compareTo(Object o) {
        return this.userName.compareTo(((UserDTO)o).getUserName());
    }
}
