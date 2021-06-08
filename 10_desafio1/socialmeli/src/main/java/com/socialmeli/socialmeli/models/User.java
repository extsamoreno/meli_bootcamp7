package com.socialmeli.socialmeli.models;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.lang.Nullable;
import java.util.List;

@Data
@AllArgsConstructor
public class User {
    int userId;
    List<Integer> followers;
    List<Integer> follows;
}
