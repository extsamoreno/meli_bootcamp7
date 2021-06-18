package com.example.testingchallengev2.unit;

import com.example.testingchallengev2.model.request.DistrictDTO;
import com.example.testingchallengev2.model.request.HouseDTO;
import com.example.testingchallengev2.model.response.DistrictCreatedResponseDTO;
import com.example.testingchallengev2.model.response.DistrictUpdatedResponseDTO;
import com.example.testingchallengev2.model.response.NewHouseResponseDTO;
import com.example.testingchallengev2.repository.district.IDistrictRepository;
import com.example.testingchallengev2.repository.house.IHouseRepository;
import com.example.testingchallengev2.service.AdminService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class AdminServiceTest {

    @Mock
    IDistrictRepository iDistrictRepository;

    @Mock
    IHouseRepository iHouseRepository;

    @InjectMocks
    AdminService adminService;

    @Test
    public void newDistrictCreationTest()
    {
        DistrictDTO district = new DistrictDTO("San Vicente", 100.20);
        Mockito.when(iDistrictRepository.createDistrict(district.getName(), district.getPrice()))
                .thenReturn(true);
        DistrictCreatedResponseDTO expected = new DistrictCreatedResponseDTO(
                district.getName(), "District created successfully.");


        DistrictCreatedResponseDTO received = adminService.newDistrict(district);

        Mockito.verify(iDistrictRepository, Mockito.atLeastOnce())
                .createDistrict(district.getName(), district.getPrice());
        Assertions.assertEquals(expected, received);
    }

    @Test
    public void newDistrictCreationFailed()
    {
        DistrictDTO district = new DistrictDTO("San Vicente", 100.20);
        Mockito.when(iDistrictRepository.createDistrict(district.getName(), district.getPrice()))
                .thenReturn(false);
        DistrictCreatedResponseDTO expected = new DistrictCreatedResponseDTO(
                district.getName(),
                "Can't create district. May be already exist.");

        DistrictCreatedResponseDTO received = adminService.newDistrict(district);

        Mockito.verify(iDistrictRepository, Mockito.atLeastOnce())
                .createDistrict(district.getName(), district.getPrice());
        Assertions.assertEquals(expected, received);
    }

    @Test
    public void districtUpdateTest()
    {
        DistrictDTO district = new DistrictDTO("San Vicente", 100.20);
        Mockito.when(iDistrictRepository.updateDistrict(district.getName(), district.getPrice()))
                .thenReturn(true);
        DistrictUpdatedResponseDTO expected = new DistrictUpdatedResponseDTO(
                district.getName(),
                "District updated successfully.");

        DistrictUpdatedResponseDTO received = adminService.updateDistrict(district);

        Mockito.verify(iDistrictRepository, Mockito.atLeastOnce())
                .updateDistrict(district.getName(), district.getPrice());
        Assertions.assertEquals(expected, received);
    }

    @Test
    public void districtUpdateFailed()
    {
        DistrictDTO district = new DistrictDTO("San Vicente", 100.20);
        Mockito.when(iDistrictRepository.updateDistrict(district.getName(), district.getPrice()))
                .thenReturn(false);
        DistrictUpdatedResponseDTO expected = new DistrictUpdatedResponseDTO(
                district.getName(),
                "Can't update district. May be it doesn't exist.");

        DistrictUpdatedResponseDTO received = adminService.updateDistrict(district);

        Mockito.verify(iDistrictRepository, Mockito.atLeastOnce())
                .updateDistrict(district.getName(), district.getPrice());
        Assertions.assertEquals(expected, received);
    }

    @Test
    public void newHouseCreationTest()
    {
        HouseDTO newHouse = TestUtils.getHouseDTOWithName("Casa 1");
        Mockito.when(iHouseRepository.createHouse(newHouse))
                .thenReturn(true);
        NewHouseResponseDTO expected = new NewHouseResponseDTO(
                newHouse.getName(), "House created successfully.", newHouse);


        NewHouseResponseDTO received = adminService.createHouse(newHouse);

        Mockito.verify(iHouseRepository, Mockito.atLeastOnce())
                .createHouse(newHouse);
        Assertions.assertEquals(expected, received);
    }

    @Test
    public void newHouseCreationFailedTest()
    {
        HouseDTO newHouse = TestUtils.getHouseDTOWithName("Casa 1");
        Mockito.when(iHouseRepository.createHouse(newHouse))
                .thenReturn(false);
        NewHouseResponseDTO expected = new NewHouseResponseDTO(
                newHouse.getName(), "Can't create house. May be already exist.", newHouse);


        NewHouseResponseDTO received = adminService.createHouse(newHouse);

        Mockito.verify(iHouseRepository, Mockito.atLeastOnce())
                .createHouse(newHouse);
        Assertions.assertEquals(expected, received);
    }
}
