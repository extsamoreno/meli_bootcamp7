package com.meli.demo.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DateUserFollowDTO {

    private int userId;
    private Date Datefollow;
}
