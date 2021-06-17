package com.example.DesafioTasaciones.exceptions;
import com.example.DesafioTasaciones.controllers.HouseExceptionController;
import org.springframework.http.HttpStatus;
public class DistrictNotFound extends ErrorException {
    public DistrictNotFound(String district_name) {
        super("District " +district_name+ " not found", HttpStatus.BAD_REQUEST);
    }
}
