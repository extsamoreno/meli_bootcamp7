package desafio1.desafio1.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.tomcat.jni.Local;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Publications {

    private int id_post;
    @JsonFormat(pattern="dd-MM-yyyy")
    private Date date;
    private Product detail;
    private int category;
    private double price;

}