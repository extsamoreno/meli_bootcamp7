package com.example.challenge2.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Property {

   private int propId;
   private String prop_Name;
   private District district;

   }

