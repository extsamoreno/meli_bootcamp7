package com.example.desafio1.exceptions.user;

import org.springframework.http.HttpStatus;

public class NotFollowedException extends UserException {
    public NotFollowedException(int userId) {
        super("No puedes dejar de seguir al usuario: " + userId + " ya que no lo sigues.", HttpStatus.BAD_REQUEST);
    }
}
