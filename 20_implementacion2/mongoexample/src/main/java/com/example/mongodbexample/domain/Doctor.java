package com.example.mongodbexample.domain;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Doctor {
  private String firstName;
  private String lastName;
  private String specialty;
}