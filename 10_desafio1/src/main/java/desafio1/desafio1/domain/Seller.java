package desafio1.desafio1.domain;

import java.util.ArrayList;
import java.util.List;

public class Seller extends User{
    private int userId;
    private String userName;
    private List<User> users = new ArrayList<>();
    private List<Publications> publications = new ArrayList<>();

}
