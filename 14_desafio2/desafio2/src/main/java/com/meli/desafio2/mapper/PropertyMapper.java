package com.meli.desafio2.mapper;

import com.meli.desafio2.dto.*;

import java.util.ArrayList;

public class PropertyMapper {
    public static PropertyFullDTO DTOToResponseDTO(PropertyDTO property, DistrictDTO districtDTO){
        return new PropertyFullDTO(property.getProp_id(), property.getProp_name(),districtDTO, property.getEnvironments());
    }

    public static PropertySquareDTO DTOToSqusreDTO(PropertyFullDTO property, Double squareMeters) {
        return new PropertySquareDTO(property.getProp_id(), property.getProp_name(),squareMeters);
    }

    public static PropertyValueDTO fullDTOtoValueDTO(PropertyFullDTO property, double value) {
        return new PropertyValueDTO(property.getProp_id(), property.getProp_name(), value);
    }

    public static PropertyBiggestEnvironmentDTO DTOToBiggestDTO(PropertyDTO property, EnvironmentSquareDTO biggest) {
        return new PropertyBiggestEnvironmentDTO(property.getProp_id(), property.getProp_name(), biggest);
    }

    public static PropertyAllSquareDTO DTOToAllSquareDTO(PropertyDTO property, ArrayList<EnvironmentSquareDTO> environmentSquareList) {
        return new PropertyAllSquareDTO(property.getProp_id(), property.getProp_name(), environmentSquareList);
    }

    public static PropertyDTO InputDTOToDTO(PropertyInputDTO propertyInput) {
        return new PropertyDTO(-1, propertyInput.getProp_name(),-1, propertyInput.getEnvironments());
    }
}
