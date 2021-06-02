package com.springbootday2.springbootday2.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CertificateDTO {
    private String message;
    private String NameStudent;
    private float average;
}
