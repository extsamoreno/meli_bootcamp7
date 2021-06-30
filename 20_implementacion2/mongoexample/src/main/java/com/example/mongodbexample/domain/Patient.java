package com.example.mongodbexample.domain;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Patient {
  private String firstName;
  private String lastName;
  private int age;
  private String gender;
}
