package meli.springchallenge.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FollowListDTO {

    private int userId;
    private String userName;
    private List<UserDTO> relateds;
}
