package com.example.demo.project.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter @Getter
@AllArgsConstructor
@NoArgsConstructor
public class FollowedPublicationsDTO {
    private UserDTO user;
    private List<PublicationDTO> publicationsDTO;
}
