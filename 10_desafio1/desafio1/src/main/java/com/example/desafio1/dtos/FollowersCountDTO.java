package com.example.desafio1.dtos;

import com.example.desafio1.dtos.ReportDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FollowersCountDTO extends ReportDTO {
    private int followersCount;
}
