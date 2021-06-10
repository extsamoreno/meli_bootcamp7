package com.SocialMeli.exceptions;

import com.SocialMeli.controller.UserController;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorDTO {
    private String message;
    private String name;
}
