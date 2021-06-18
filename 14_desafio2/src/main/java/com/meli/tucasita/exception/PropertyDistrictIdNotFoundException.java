package com.meli.tucasita.exception;

import org.springframework.http.HttpStatus;

public class PropertyDistrictIdNotFoundException extends PropertyException {
  public PropertyDistrictIdNotFoundException(Integer districtId) {
    super("El id: "+ districtId +" no corresponde a ningun barrio en nuestro sistema", HttpStatus.BAD_REQUEST);
  }
}
