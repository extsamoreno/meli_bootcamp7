package SquareMeterCalculator.Mapper;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
@Data
@AllArgsConstructor
public class ResponseSquareMeterDTO {
    private String result;
    private HttpStatus status;
}
