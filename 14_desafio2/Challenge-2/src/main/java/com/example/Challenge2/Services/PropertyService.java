package com.example.Challenge2.Services;

import com.example.Challenge2.Exceptions.DistrictNotFoundException;
import com.example.Challenge2.Exceptions.PropertyNotFoundException;
import com.example.Challenge2.Models.District;
import com.example.Challenge2.Models.Property;
import com.example.Challenge2.Repositories.IDataRepository;
import com.example.Challenge2.Services.DTOs.*;
import com.example.Challenge2.Services.Mapper.DistrictMapper;
import com.example.Challenge2.Services.Mapper.PropertyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PropertyService implements IPropertyService{

    @Autowired
    IDataRepository iDataRepository;
    public PropertyDTO getPropertyById(Long id) throws PropertyNotFoundException {
        Property property = iDataRepository.getPropertyById(id);

        if(property != null){
            return PropertyMapper.toDTO(property);
        }
        else {
            throw new PropertyNotFoundException(id);
        }
    }

    private District getDistrictById(Long id) throws DistrictNotFoundException {
        District district = iDataRepository.getDistrictById(id);

        if(district != null){
            return district;
        }
        else {
            throw new DistrictNotFoundException(id);
        }
    }
    public List<StructureDTO> getDimensionedRooms(Long id) throws PropertyNotFoundException {

        List<StructureDTO> output = new ArrayList<>();
        PropertyDTO propertyDTO= this.getPropertyById(id);

        for (int i = 0; i < propertyDTO.getRooms().size(); i++) {

            double mt2s = this.calculateM2(propertyDTO.getRooms().get(i));
            StructureDTO structure = new StructureDTO(mt2s , propertyDTO.getRooms().get(i).getName());
            output.add(structure);
        }

        return output;

    }
    public StructureDTO getPropertyDimensions(Long id) throws PropertyNotFoundException {

        PropertyDTO propertyDTO= this.getPropertyById(id);


        double dimentions = this.calculatePropertyDimensions(propertyDTO.getRooms());


        return new StructureDTO(dimentions,propertyDTO.getName());

    }
    public ValueDTO getPropertyValue(Long id) throws PropertyNotFoundException, DistrictNotFoundException {

        PropertyDTO propertyDTO= this.getPropertyById(id);

        double dimentions = this.calculatePropertyDimensions(propertyDTO.getRooms());

        DistrictDTO districtDTO = DistrictMapper.toDTO(this.getDistrictById(propertyDTO.getDistrictId()));

        return new ValueDTO(dimentions* districtDTO.getPricePerM2());

    }
    public RoomDTO getBiggestRoom(Long id) throws PropertyNotFoundException {

        PropertyDTO propertyDTO= this.getPropertyById(id);

        RoomDTO output = new RoomDTO("",0.0,0.0);


        for (int i = 0; i < propertyDTO.getRooms().size(); i++) {

            if(this.calculateM2(propertyDTO.getRooms().get(i)) >= this.calculateM2(output)){
                output = propertyDTO.getRooms().get(i);
            }
        }

        output.setM2(this.calculateM2(output));
        return output;

    }

    private double calculateM2(RoomDTO room){
        return room.getLength()* room.getWidth();
    }

    private double calculatePropertyDimensions(List<RoomDTO> roomDTOS){
        double output= 0.0;
        for (int i = 0; i < roomDTOS.size(); i++) {
            output = output + this.calculateM2(roomDTOS.get(i));
        }
        return output;
    }

}
