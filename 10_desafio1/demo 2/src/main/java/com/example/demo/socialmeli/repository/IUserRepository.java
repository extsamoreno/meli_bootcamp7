package com.example.demo.socialmeli.repository;

import com.example.demo.socialmeli.service.dto.UserDTO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface IUserRepository {
    User getUserById(int id);
    void refreshUser(User user);
    List<User> getAllUsers ();
    void refreshPublications(Publication publication);
    List<Publication> getAllPublication();

}
