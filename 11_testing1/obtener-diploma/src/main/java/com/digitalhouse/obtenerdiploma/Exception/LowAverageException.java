package com.digitalhouse.obtenerdiploma.Exception;

import lombok.Data;

@Data
public class LowAverageException extends Throwable {
    String message;

    public LowAverageException(Double average) {
        this.message = "Low Average "+average;;
    }
}
