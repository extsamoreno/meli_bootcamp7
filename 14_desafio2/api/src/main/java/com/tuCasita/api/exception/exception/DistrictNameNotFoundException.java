package com.tuCasita.api.exception.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.text.MessageFormat;

@Getter
public class DistrictNameNotFoundException extends GlobalException{
    public DistrictNameNotFoundException(String districtName){
        super(MessageFormat.format("The district ''{0}'' is not found, please check that name.", districtName), HttpStatus.BAD_REQUEST);
    }
}
