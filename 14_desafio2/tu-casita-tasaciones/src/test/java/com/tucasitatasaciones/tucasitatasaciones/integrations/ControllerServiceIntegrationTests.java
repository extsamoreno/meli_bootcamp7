package com.tucasitatasaciones.tucasitatasaciones.integrations;

import com.tucasitatasaciones.tucasitatasaciones.repositories.IDistrictRepository;
import com.tucasitatasaciones.tucasitatasaciones.repositories.IOwnerRepository;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class ControllerServiceIntegrationTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IDistrictRepository districtRepository;

    @MockBean
    private IOwnerRepository ownerRepository;
}
