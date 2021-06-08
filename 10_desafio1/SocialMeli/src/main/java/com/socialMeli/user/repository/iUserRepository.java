package com.socialMeli.user.repository;

import com.socialMeli.user.exceptions.UserIdNotFoundException;
import com.socialMeli.user.exceptions.UserNotFoundException;

public interface iUserRepository {

    Object findById(Integer id) throws UserNotFoundException;
    Integer findByUser (Object user) throws UserIdNotFoundException;
}
