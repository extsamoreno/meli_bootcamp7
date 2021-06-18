package com.desafio2.testing.Repository;

import com.desafio2.testing.Model.RoomModel;
import com.desafio2.testing.Model.DistrictModel;
import com.desafio2.testing.Model.PropertyModel;

import java.util.ArrayList;

public interface IPropertyRepository {
  PropertyModel getPropertyByName(String name);


  boolean addProperty(String name, DistrictModel districtModel, ArrayList<RoomModel> roomModels, int cant);
  boolean addProperty(PropertyModel property);

}
