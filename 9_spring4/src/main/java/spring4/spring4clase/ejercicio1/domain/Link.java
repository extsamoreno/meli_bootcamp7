package spring4.spring4clase.ejercicio1.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class Link {
    private int linkid;
    private String password;
    private String link;
    private int views;
}
