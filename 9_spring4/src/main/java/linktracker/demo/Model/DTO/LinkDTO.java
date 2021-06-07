package linktracker.demo.Model.DTO;

import lombok.Data;

@Data
public class LinkDTO {
    String link;
    String password;
    boolean isInvalidated = false;
    int numberOfRedirects = 0;

    public LinkDTO(String link, String password) {
        this.link = link;
        this.password = password;
    }
}
