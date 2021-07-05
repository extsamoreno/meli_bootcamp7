package com.appconsultorio.appconsultorio.dtos.response;

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
public class TurnDTOResponse {
    private String description;
    private String status;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date startTime;
    private Integer idPatient;
    private List<Integer> idDentist;
}
