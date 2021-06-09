package meli.social.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter

public class UserModel {
    private int UserId;
    private String userName;
    private ArrayList<Integer> followers;
    private ArrayList<Integer> followed;
    private ArrayList<Integer> posts;
}
