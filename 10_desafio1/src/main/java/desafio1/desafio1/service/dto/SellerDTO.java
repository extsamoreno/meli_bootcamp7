package desafio1.desafio1.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SellerDTO {
    private int userId;
    private String userName;
    private int followers_count;
}
