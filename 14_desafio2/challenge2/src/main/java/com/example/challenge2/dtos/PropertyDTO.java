package com.example.challenge2.dtos;

import com.example.challenge2.models.Environment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

public class PropertyDTO {
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @NotNull
    public class District {

        private String name;
        private String districtName;
        private List<Environment> environmentList;

    }

}
