package com.appconsultorio.appconsultorio.dtos.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@Setter @Getter
public class CalendarsDTO {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date day;

    private boolean turn1;
    private boolean turn2;
    private boolean turn3;
    private boolean turn4;
    private boolean turn5;
    private boolean turn6;
    private boolean turn7;
    private boolean turn8;
    private boolean turn9;
    private boolean turn10;
    private boolean turn11;
    private boolean turn12;
    private boolean turn13;
    private boolean turn14;
    private boolean turn15;
    private boolean turn16;

}
