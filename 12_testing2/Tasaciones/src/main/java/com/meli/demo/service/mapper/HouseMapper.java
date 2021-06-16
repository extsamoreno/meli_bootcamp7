package com.meli.demo.service.mapper;


import com.meli.demo.dto.HouseDTO;
import com.meli.demo.model.House;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

public class HouseMapper {

    public static HouseDTO toDTO(House post){
        return new HouseDTO(post.getName(),
                post.getNeighborhood(),
                post.getEnvironments());
    }

    public static House toHouse(HouseDTO post){
        return new House(post.getName(),
                post.getNeighborhood(),
                post.getEnvironments());
    }
}
