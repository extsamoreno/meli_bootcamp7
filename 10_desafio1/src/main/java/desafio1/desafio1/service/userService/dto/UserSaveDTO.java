package desafio1.desafio1.service.userService.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserSaveDTO {
    private int userId;
    private String userName;
    private int isSeller;

    /**
     * this class are the ones that are saved in the followers of each one,
     * so as not to save the entire user object
     */
}

