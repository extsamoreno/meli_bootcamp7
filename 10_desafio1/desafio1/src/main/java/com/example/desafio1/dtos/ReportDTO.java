package com.example.desafio1.dtos;

import com.example.desafio1.repositories.IUserRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class ReportDTO {
    private int userId;
    private String userName;
}
