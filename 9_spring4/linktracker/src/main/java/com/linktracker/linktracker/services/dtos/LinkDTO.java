package com.linktracker.linktracker.services.dtos;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class LinkDTO {
    String link;
    String password;
    int linkId;
    int counterRedirect;
    boolean valid;
}
