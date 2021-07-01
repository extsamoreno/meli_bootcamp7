package com.example.mongodbexample.dto;

import com.example.mongodbexample.domain.Doctor;
import com.example.mongodbexample.domain.Patient;
import lombok.*;
import org.springframework.data.annotation.Id;
import java.time.LocalDate;

@AllArgsConstructor
@Data

public class ScheduleDoctorDto {
  @Id private String id;
  private Patient patient;
  private LocalDate date;
  private String status;
}
