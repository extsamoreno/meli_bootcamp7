package com.example.desafio1.dtos;

import com.example.desafio1.repositories.IUserRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@NoArgsConstructor
@AllArgsConstructor
//Since most DTO response classes use one same set of fields, we can use this abstract class to make them inherit them
public abstract class ReportDTO {
    private int userId;
    private String userName;
}
