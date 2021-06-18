package com.TuCasitaTasacionesAPI.TuCasita.unit;

import com.TuCasitaTasacionesAPI.TuCasita.UtilsDataTests;
import com.TuCasitaTasacionesAPI.TuCasita.exceptions.district.DistrictAlreadyExistsException;
import com.TuCasitaTasacionesAPI.TuCasita.exceptions.district.DistrictNotFoundException;
import com.TuCasitaTasacionesAPI.TuCasita.models.District;
import com.TuCasitaTasacionesAPI.TuCasita.repositories.DistrictRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class DistrictRepositoryUnitTest {

    DistrictRepository districtRepository = new DistrictRepository();

    @Test
    public void getByIdHappyPath() {
        District expected = UtilsDataTests.generateDistrict();

        districtRepository.create(expected);

        assertEquals(districtRepository.getById(expected.getDistrict_id()), expected);

        districtRepository.delete(expected.getDistrict_id());
    }
}
