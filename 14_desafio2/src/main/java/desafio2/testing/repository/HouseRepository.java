package desafio2.testing.repository;

import desafio2.testing.domian.District;
import desafio2.testing.domian.EnvironmentHouse;
import desafio2.testing.domian.House;
import desafio2.testing.exception.HouseExistException;
import desafio2.testing.exception.NotFoundException;
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
        EnvironmentHouse e1 = new EnvironmentHouse("bath", 2,2);
        EnvironmentHouse e2 = new EnvironmentHouse("room", 6,6);
        EnvironmentHouse e3 = new EnvironmentHouse("yard", 15,20);
        List<EnvironmentHouse> eList1 = new ArrayList<>();
        eList1.add(e1);
        eList1.add(e2);
        eList1.add(e3);
        houseList.add(new House(1,"house1", new District(1, "center", 500), eList1));


        EnvironmentHouse e12 = new EnvironmentHouse("bath", 3,2);
        EnvironmentHouse e22 = new EnvironmentHouse("room", 5,6);
        EnvironmentHouse e32 = new EnvironmentHouse("yard", 15,10);
        List<EnvironmentHouse> eList12 = new ArrayList<>();
        eList1.add(e12);
        eList1.add(e22);
        eList1.add(e32);
        houseList.add(new House(1,"house1", new District(2, "center", 500), eList12));


        EnvironmentHouse e123 = new EnvironmentHouse("bath", 3,9);
        EnvironmentHouse e223 = new EnvironmentHouse("room", 5,7);
        EnvironmentHouse e323 = new EnvironmentHouse("yard", 5,10);
        List<EnvironmentHouse> eList123 = new ArrayList<>();
        eList1.add(e123);
        eList1.add(e223);
        eList1.add(e323);
        houseList.add(new House(1,"house1", new District(3, "south", 400), eList123));

        return houseList;
    }

    private List<District> loadDataBaseDistrict(){
        districtList.add(new District(1,"center",500));
        districtList.add(new District(2, "south", 400));
        return districtList;
    }


    @Override
    public House findUserById(int houseId) throws NotFoundException {

        House houseResult = null;

        if(houseList != null){
            Optional<House> item = houseList.stream().filter(u -> u.getId() == houseId).findFirst();

            if(item.isPresent()) {
                houseResult = item.get();
            }
        }

        if(houseResult==null){
            throw new NotFoundException();
        }

        return houseResult;
    }

    @Override
    public void addHouse(House house) throws HouseExistException {
        Optional<House> item = houseList.stream().filter(
                h -> h.getId()==house.getId()).findFirst();

        if(item.isPresent()){
            throw new HouseExistException();
        }

        houseList.add(house);
    }

}
