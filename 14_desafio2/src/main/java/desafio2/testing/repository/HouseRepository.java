package desafio2.testing.repository;

import desafio2.testing.domian.District;
import desafio2.testing.domian.EnvironmentHouse;
import desafio2.testing.domian.House;
import desafio2.testing.exception.DisctictException;
import desafio2.testing.exception.HouseExistException;
import desafio2.testing.exception.NotFoundException;
import desafio2.testing.service.dto.EnvironmentHouseDTO;
import desafio2.testing.service.dto.HouseDTO;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class HouseRepository implements IHouseRepository{
    private List<House> houseList = new ArrayList<>(); //cuando hace el autowire ejecuta esto antes que el contructor y si no esta inicializado rompe
    private List<District> districtList = new ArrayList<>();

    public HouseRepository() {
        this.houseList = loadDataBaseHouse();
        this.districtList = loadDataBaseDistrict();
    }

    private List<House> loadDataBaseHouse() {
        EnvironmentHouse e1 = new EnvironmentHouse("bath", 2.0,2.0);
        EnvironmentHouse e2 = new EnvironmentHouse("room", 6.0,6.0);
        EnvironmentHouse e3 = new EnvironmentHouse("yard", 15.0,20.0);
        List<EnvironmentHouse> eList1 = new ArrayList<>();
        eList1.add(e1);
        eList1.add(e2);
        eList1.add(e3);
        houseList.add(new House(1,"house1", new District(1, "center", 500.0), eList1));


        EnvironmentHouse e12 = new EnvironmentHouse("bath", 3.0,2.0);
        EnvironmentHouse e22 = new EnvironmentHouse("room", 5.0,6.0);
        EnvironmentHouse e32 = new EnvironmentHouse("yard", 15.0,10.0);
        List<EnvironmentHouse> eList12 = new ArrayList<>();
        eList12.add(e12);
        eList12.add(e22);
        eList12.add(e32);
        houseList.add(new House(1,"house1", new District(2, "center", 500.0), eList12));


        EnvironmentHouse e123 = new EnvironmentHouse("bath", 3.0,9.0);
        EnvironmentHouse e223 = new EnvironmentHouse("room", 5.0,7.0);
        EnvironmentHouse e323 = new EnvironmentHouse("yard", 5.0,10.0);
        List<EnvironmentHouse> eList123 = new ArrayList<>();
        eList123.add(e123);
        eList123.add(e223);
        eList123.add(e323);
        houseList.add(new House(1,"house1", new District(3, "south", 400.0), eList123));

        return houseList;
    }

    private List<District> loadDataBaseDistrict(){
        districtList.add(new District(1,"center",500.0));
        districtList.add(new District(2, "south", 400.0));
        return districtList;
    }


    public House findHouseById(int houseId) throws NotFoundException {

        House houseResult = null;

        if(houseList != null){
            Optional<House> item = houseList.stream().filter(u -> u.getId() == houseId).findFirst();

            if(item.isPresent()) {
                houseResult = item.get();
            }
        }

        if(houseResult ==null){
            throw new NotFoundException();
        }

        return houseResult;
    }

    @Override
    public void addHouse(HouseDTO houseDTO) throws HouseExistException, DisctictException {
        Optional<House> item = houseList.stream().filter(
                h -> h.getId()== houseDTO.getId()).findFirst();

        if(item.isPresent()){
            throw new HouseExistException();
        }

        Optional<District> item2 = districtList.stream().filter(
                d-> d.getId() == houseDTO.getDistrict().getId()).findFirst();

        if(item2.isEmpty()){
            throw new DisctictException(houseDTO.getDistrict().getId());
        }

        List<EnvironmentHouse> environmentHouseList = new ArrayList<>();
        for(EnvironmentHouseDTO e : houseDTO.getEnvironments()){
            environmentHouseList.add(new EnvironmentHouse(e.getName(),e.getWidth(),e.getLength()));
        }

        House house = new House(houseDTO.getId(),houseDTO.getProp_name(),new District(houseDTO.getDistrict().getId(),houseDTO.getDistrict().getName(),houseDTO.getDistrict().getPrice()),environmentHouseList);
        houseList.add(house);
    }

}
