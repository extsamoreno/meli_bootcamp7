package com.consultoriomongo.demo.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
public class Patient {

    private String name;

    @Field("tel")
    private String tell;
}
