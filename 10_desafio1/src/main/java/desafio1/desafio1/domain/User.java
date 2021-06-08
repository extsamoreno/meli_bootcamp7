package desafio1.desafio1.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Data
@AllArgsConstructor

public class User {
    private int userId;
    private String userName;
    private List<User> followList; //quienes sigo yo
    private List<User> followMeList; //quienes me siguen
    private List<Publications> publicationsList;

    public User() {
        this.userId = -1;
        this.userName = "";
        this.followList = new ArrayList<>();
        this.followMeList = new ArrayList<>();
        this.publicationsList = new ArrayList<>();
    }

    //el usuario comun y el vendedor don el mismo tipo de objeto, cuando se tratae de un vendedor,
    //tendra las listas de publicaciones, sino estará vacia, ademas el nombre será o usuario o vendedor

}
