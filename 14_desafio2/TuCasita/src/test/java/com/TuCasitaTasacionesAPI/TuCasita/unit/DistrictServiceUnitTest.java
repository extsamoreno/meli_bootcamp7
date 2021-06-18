package com.TuCasitaTasacionesAPI.TuCasita.unit;

import com.TuCasitaTasacionesAPI.TuCasita.UtilsDataTests;
import com.TuCasitaTasacionesAPI.TuCasita.dtos.DistrictDTO;
import com.TuCasitaTasacionesAPI.TuCasita.exceptions.district.DistrictAlreadyExistsException;
import com.TuCasitaTasacionesAPI.TuCasita.exceptions.district.DistrictNotFoundException;
import com.TuCasitaTasacionesAPI.TuCasita.models.District;
import com.TuCasitaTasacionesAPI.TuCasita.repositories.IDistrictRepository;
import com.TuCasitaTasacionesAPI.TuCasita.services.DistrictService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DistrictServiceUnitTest {

    @Mock
    IDistrictRepository iDistrictRepository;

    @Mock
    ModelMapper mapper;

    @InjectMocks
    DistrictService districtService;

    @Test
    public void createHappyPath() throws DistrictAlreadyExistsException {

        District district = UtilsDataTests.generateDistrict();
        int idExpected = district.getDistrict_id();
        DistrictDTO districtDTO = UtilsDataTests.generateDistrictDTO();

        when(iDistrictRepository.checkDistrictExists(district)).thenReturn(false);
        when(iDistrictRepository.create(district)).thenReturn(idExpected);
        when(mapper.map(districtDTO, District.class)).thenReturn(district);

        int idReceived = districtService.create(districtDTO);

        assertEquals(idExpected, idReceived);
    }

    @Test
    public void createWithDistrictThatAlreadyExist() {

        District district = UtilsDataTests.generateDistrict();
        DistrictDTO districtDTO = UtilsDataTests.generateDistrictDTO();

        when(mapper.map(districtDTO, District.class)).thenReturn(district);
        when(iDistrictRepository.checkDistrictExists(district)).thenReturn(true);

        assertThrows(DistrictAlreadyExistsException.class, () -> districtService.create(districtDTO));
    }

    @Test
    public void getByIdWithIdValid() throws DistrictNotFoundException {

        District district = UtilsDataTests.generateDistrict();
        int id = district.getDistrict_id();
        DistrictDTO expected = UtilsDataTests.generateDistrictDTO();

        when(iDistrictRepository.getById(id)).thenReturn(district);
        when(mapper.map(district, DistrictDTO.class)).thenReturn(expected);

        DistrictDTO received = districtService.getById(id);

        assertEquals(expected, received);
    }

    @Test
    public void getByIdWithIdInvalid() throws DistrictNotFoundException {
        int id = -1;

        when(iDistrictRepository.getById(id)).thenReturn(null);

        assertThrows(DistrictNotFoundException.class, () -> districtService.getById(id));
    }



}
