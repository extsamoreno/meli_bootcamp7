package bootcamp.cuatro.spring.service.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponseLinkDTO {
    private Integer linkId;
    private String url;
    private Boolean active;
    private int consultTimes;
    private String password;
}
