package desafio1.desafio1.service.userService.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SellerCountDTO {
    private int userId;
    private String userName;
    private int followers_count;
    private int IsSeller;
}
