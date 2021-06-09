package com.reto1.demo.Model.UserObjets;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTOCount {
    int id;
    String name;
    int followers_count;
}
