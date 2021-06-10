package desafio1.demo.Model.DTO;

import lombok.Data;

@Data
public class PromoCountDTO {
    int userId;
    String userName;
    long promoproducts_count;

    public PromoCountDTO(int userId, String userName, long promoproducts_count) {
        this.userId = userId;
        this.userName = userName;
        this.promoproducts_count = promoproducts_count;
    }
}
