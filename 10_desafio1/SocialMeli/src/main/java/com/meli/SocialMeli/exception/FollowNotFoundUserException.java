package com.meli.SocialMeli.exception;

import com.meli.SocialMeli.model.User;

public class FollowNotFoundUserException extends UserException {
    public FollowNotFoundUserException() {
        super("This user does not follow the selected seller");
    }
}
