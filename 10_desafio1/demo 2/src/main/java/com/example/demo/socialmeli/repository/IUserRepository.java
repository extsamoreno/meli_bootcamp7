package com.example.demo.socialmeli.repository;

import com.example.demo.socialmeli.exception.FollowedExistingException;
import com.example.demo.socialmeli.exception.UserNotFoundException;
import com.example.demo.socialmeli.models.Publication;
import com.example.demo.socialmeli.models.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserRepository {
    User getUserById(int id) throws UserNotFoundException;
    void refreshUser(User user) throws FollowedExistingException;
    List<User> getAllUsers ();
    void refreshPublications(Publication publication);
    List<Publication> getAllPublication();

}
