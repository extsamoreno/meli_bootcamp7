package com.example.demo.project.excercise2.repository.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.net.Inet4Address;
import java.util.List;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class CharacterSWListDTO {

    private List<CharacterSW> characterSWList;

}
