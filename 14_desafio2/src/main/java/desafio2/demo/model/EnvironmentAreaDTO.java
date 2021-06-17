package desafio2.demo.model;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
public class EnvironmentAreaDTO {
    String name;
    double width;
    double length;
    double area;

    public EnvironmentAreaDTO(EnvironmentDTO environmentDTO, double area) {
        this.name = environmentDTO.getName();
        this.width = environmentDTO.getWidth();
        this.length = environmentDTO.getLength();
        this.area = area;
    }
}
