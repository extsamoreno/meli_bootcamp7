package spring4.spring4clase.ejercicio1.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor

public class ViewsResponse {
    private int linkid;
    private String link;
    private int views;
}