package com.socialMeli.user.repository;

import com.socialMeli.user.exceptions.UserIdNotFoundException;
import com.socialMeli.user.exceptions.UserNotFoundException;
import com.socialMeli.user.models.Seller;
import com.socialMeli.user.models.User;
import org.springframework.stereotype.Repository;
import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.bidimap.TreeBidiMap;


import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class UserRepository implements iUserRepository {

    private BidiMap<Integer, User> users;
    private BidiMap<Integer, Seller> sellers;
    private AtomicInteger userId = new AtomicInteger(1);

    @Override
    public Object findById(Integer id) throws UserNotFoundException {
        Object result = users.get(userId);
        if (result == null)
            result = sellers.get(userId);
        if (result == null)
            throw new UserNotFoundException(id);
        return result;
    }

    @Override
    public Integer findByUser (Object user) throws UserIdNotFoundException {
        Integer result = users.getKey(user);
        if (result == null)
            result = sellers.getKey(user);
        if (result == null)
            throw new UserIdNotFoundException();
        return result;
    }
}
