package com.desafio2.testing.Repository;

import com.desafio2.testing.Model.RoomModel;
import com.desafio2.testing.Model.DistrictModel;
import com.desafio2.testing.Model.PropertyModel;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class PropertyRepository implements IPropertyRepository {

    private final static ArrayList<PropertyModel> propertyDataBase = new ArrayList<>();




    public boolean addProperty(String name, DistrictModel districtModel, ArrayList<RoomModel> roomModels, int cant){
        PropertyModel propertyModel =new PropertyModel(name, districtModel, roomModels, cant);
        return   propertyDataBase.add(propertyModel);
    }

    public boolean addProperty(PropertyModel property){
        return propertyDataBase.add(property);
    }




    @Override
    public PropertyModel getPropertyByName(String name) {

        for (PropertyModel p : propertyDataBase) {
            if (p.getProp_name().equals(name)) {
                return p;
            }
        }
        return null;
    }
}
