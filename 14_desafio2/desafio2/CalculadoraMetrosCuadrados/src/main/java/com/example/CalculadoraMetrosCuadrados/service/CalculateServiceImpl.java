package com.example.CalculadoraMetrosCuadrados.service;

import com.example.CalculadoraMetrosCuadrados.dto.*;
import com.example.CalculadoraMetrosCuadrados.exceptions.DistrictNotFoundException;
import com.example.CalculadoraMetrosCuadrados.repository.IDistrictRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service("CalculateService")
@Primary
public class CalculateServiceImpl implements ICalculateService {

  @Autowired
  IDistrictRepository districtRepository;

  //US-0001
  @Override
  public HouseResponseTotalSquareFeetDTO calculateTotalSquareFeet(HouseDTO house) {
    var response = new HouseResponseTotalSquareFeetDTO( calculateRoomSquareFeet(house) );
    return response;
  }

  //US-0002
  @Override
  public HouseResponseValueDTO calculatePrice(HouseDTO house) {
    var square = calculateRoomSquareFeet(house) * priceByDistrict( house.getDistrictName(), house.getDistrictPrice() );
    var response = new HouseResponseValueDTO( square );
    return response;
  }

  //US-0003
  @Override
  public RoomDTO getBiggestRoom(HouseDTO house) {
    return calculateBiggestRoom(house);
  }

  //US-0004
  @Override
  public HouseResponseSquareFeetPerRoomDTO calculateSquareFeetPerRoom(HouseDTO house) {
    var rooms = new ArrayList<RoomSquareFeetDTO>();

    for (RoomDTO room : house.getRooms()) {
      Integer squareFeet = getSquareFeet(room);
      rooms.add(new RoomSquareFeetDTO( room.getRoomName(), squareFeet ));
    }

    var response = new HouseResponseSquareFeetPerRoomDTO( rooms );
    return response;
  }

  private Integer getSquareFeet(RoomDTO room) {
    Integer result = 0;
    if(room.getRoomWidth() != null && room.getRoomLength() != null)
      result = room.getRoomWidth() * room.getRoomLength();
    return result;
  }

  private Integer calculateRoomSquareFeet(HouseDTO house) {
    Integer totalSquareFeet = 0;
    for (RoomDTO room : house.getRooms()) {
      totalSquareFeet += getSquareFeet(room);
    }

    return totalSquareFeet;
  }

  private RoomDTO calculateBiggestRoom(HouseDTO house) {
    RoomDTO biggest = null;
    Integer maxRoom = 0;
    for (RoomDTO room : house.getRooms()) {
      Integer squareFeet = getSquareFeet(room);
      if (biggest == null || squareFeet > maxRoom){
        biggest = room;
        maxRoom = squareFeet;
      }
    }

    return biggest;
  }

  private Double priceByDistrict(String districtName, Double districtPrice) {
    var price =districtByNameAndPrice(districtName, districtPrice).getDistrictPrice();
    System.out.println(price);
    return price;
  }

  /*
  * Calls districRepository to find district by it's name and price.
  * Returns the district.
  * Throws: NoSuchFieldException.
  */
  private District districtByNameAndPrice(String districtName, Double districtPrice){
    District district = null;
    try{
      district = districtRepository.getDistrictByNameAndPrice(districtName, districtPrice);
    }catch (NoSuchFieldException e){
      e.printStackTrace();
    }
    return district;
  }

}
