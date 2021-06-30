package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.Date;

@Data
public class ScheduleDTO {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long id;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date date;

    private Long dentistId;

}
