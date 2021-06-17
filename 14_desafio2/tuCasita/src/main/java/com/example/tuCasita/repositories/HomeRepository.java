package com.example.tuCasita.repositories;

import com.example.tuCasita.exceptions.AlreadyExistDistrictException;
import com.example.tuCasita.exceptions.AlreadyExistHomeException;
import com.example.tuCasita.exceptions.HomeIdNotFoundException;
import com.example.tuCasita.exceptions.HomeWithNoEnviromentsException;
import com.example.tuCasita.models.District;
import com.example.tuCasita.models.Enviroment;
import com.example.tuCasita.models.Home;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class HomeRepository implements IHomeRepository{
    private HashMap<Integer, Home> homeMap = new HashMap<>();
    private HashMap<Integer, District> districtMap = new HashMap<>();

    public HomeRepository() {
        District district1 = new District(1,"District 1", 500.00);
        District district2 = new District(2,"District 2", 80.77);
        District district3 = new District(3,"District 3", 933.00);

        districtMap.put(1,district1);
        districtMap.put(2,district2);
        districtMap.put(3,district3);

        loadData();
    }

    private void loadData(){
        List<Enviroment> envList1 = new ArrayList<>();
        List<Enviroment> envList2 = new ArrayList<>();
        List<Enviroment> envList3 = new ArrayList<>();

        Enviroment env1 = new Enviroment(1,"Kitchen",5.00,10.00);
        Enviroment env2 = new Enviroment(2,"DinningRoom",20.00,10.00);
        Enviroment env3 = new Enviroment(3,"BathRoom",6.00,5.00);
        Enviroment env4 = new Enviroment(4,"BedRoom",10.00,12.00);
        Enviroment env5 = new Enviroment(5,"LivingRoom",20.00,20.00);

        envList1.add(env1);
        envList1.add(env3);
        envList1.add(env5);

        envList2.add(env2);
        envList2.add(env4);

        envList3.add(env1);
        envList3.add(env2);
        envList3.add(env3);
        envList3.add(env4);
        envList3.add(env5);

        Home home1 = new Home(1,"Home 1",districtMap.get(1),envList1);
        Home home2 = new Home(2,"Home 2",districtMap.get(2),envList2);
        Home home3 = new Home(3,"Home 3",districtMap.get(3),envList3);
        Home home4 = new Home(4,"Home 4",districtMap.get(4),envList3);

        this.homeMap.put(1,home1);
        this.homeMap.put(2,home2);
        this.homeMap.put(3,home3);
        this.homeMap.put(4,home4);
    }

    @Override
    public Home getHomeById(Integer homeId) {
        return homeMap.get(homeId);
    }

    @Override
    public District findDistrictById(Integer id) {
        return districtMap.get(id);
    }

    @Override
    public void insertHome(Home home) throws AlreadyExistHomeException {
        Home exist = homeMap.get(home.getId());

        //Check if the home is already inserted by the user
        if (exist != null){
            throw new AlreadyExistHomeException(home.getId());
        }

        homeMap.put(home.getId(),home);
    }

    @Override
    public void insertDistrict(District district) throws AlreadyExistDistrictException {
        District exist = districtMap.get(district.getId());

        //Check if the district is already inserted by the user
        if (exist != null){
            throw new AlreadyExistDistrictException(district.getId());
        }

        districtMap.put(district.getId(),district);
    }

    @Override
    public Double getSquareMeterByHome(Integer homeId) throws HomeIdNotFoundException {
        Home home = homeMap.get(homeId);

        if (homeIdNotExist(homeId))
            throw new HomeIdNotFoundException(homeId);

        Double meters = getSquareMeters(home);

        return meters;
    }

    @Override
    public Double getPrice(Integer homeId) throws HomeIdNotFoundException {
        Home home = homeMap.get(homeId);

        if (homeIdNotExist(homeId))
            throw new HomeIdNotFoundException(homeId);

        Double districtPrice = home.getDistrict().getPrice();
        Double result = districtPrice * getSquareMeterByHome(homeId);

        return result;
    }

    @Override
    public Enviroment getBiggest(Integer homeId) throws HomeIdNotFoundException, HomeWithNoEnviromentsException {
        Home home = homeMap.get(homeId);

        if (homeIdNotExist(homeId))
            throw new HomeIdNotFoundException(homeId);

        List<Enviroment> enviromentList = home.getEnviromentList();

        if (enviromentList == null || enviromentList.isEmpty()){
            throw new HomeWithNoEnviromentsException(homeId);
        }

        Optional<Enviroment> biggestEnv = enviromentList.stream().max(Comparator.comparing(e -> e.getLength() * e.getWidth()));

        return biggestEnv.get();
    }

    @Override
    public List<Enviroment> findEnviromentsById(Integer homeId) {
        return homeMap.get(homeId).getEnviromentList();
    }

    private double getSquareMeters(Home home){
        List<Enviroment> enviromentList = homeMap.get(home.getId()).getEnviromentList();
        Double meters = 0.0;

        for (int i = 0; i < enviromentList.size(); i++) {
            meters += (enviromentList.get(i).getLength() * enviromentList.get(i).getWidth());
        }

        return meters;
    }

    private boolean homeIdNotExist(Integer homeId){
        boolean valid = false;

        Home home = homeMap.get(homeId);

        if (home == null)
            valid = true;

        return valid;
    }

    private boolean existEnviromentId(Integer envId){
        boolean exist = false;
        List<Enviroment> envList = new ArrayList<>();

        /*for (int i = 0; i < homeMap.size(); i++) {
            envList.add(homeMap.get(i).getEnviromentList());
        }*/

        return exist;
    }
}
