package com.meli.desafio2.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.desafio2.dtos.EnvironmentDTO;
import com.meli.desafio2.dtos.PropertyDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PropertyControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    //Se realizaron las siguientes pruebas para asegurarse de que cada una de las validaciones de los DTO están funcionando correctamente. Cada prueba debe aplicarse también a todos los endpoint, pero por motivos prácticos solo los aplicamos al endpoint 'calculateTotalSquareFeet'.

    @Test
    void testCalculateTotalSquareMetersNullProperty() throws Exception {
        // Arrange
        PropertyDTO property = null;
        String requestProperty = objectMapper.writeValueAsString(property);

        // Act & Assert
        this.mockMvc.perform(
                post("/calculateTotalSquareMeters")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestProperty))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.name").value("HttpMessageNotReadableException"));
    }

    @Test
    void testCalculateTotalSquareMetersNullPropertyName() throws Exception {
        // Arrange
        // Rooms initialize
        EnvironmentDTO environment1 = new EnvironmentDTO("Habitacion", 3, 2);
        EnvironmentDTO environment2 = new EnvironmentDTO("Cocina", 2, 4);
        EnvironmentDTO environment3 = new EnvironmentDTO("Baño", 2, 2);

        // RoomList initialize
        List<EnvironmentDTO> environment = new ArrayList<>();
        environment.add(environment1);
        environment.add(environment2);
        environment.add(environment3);

        // House initialize
        PropertyDTO inputProperty = new PropertyDTO(null, environment, "Alberdi", 1000.0);

        String requestProperty = objectMapper.writeValueAsString(inputProperty);

        this.mockMvc.perform(
                post("/calculateTotalSquareMeters")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestProperty))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.name").value("MethodArgumentNotValidException"))
                .andExpect(jsonPath("$.description").value("The property name cannot be empty."));
    }

    @Test
    void testCalculateTotalSquareMetersPropertyNameFirstLetterLowerCase() throws Exception {
        // Arrange
        // Rooms initialize
        EnvironmentDTO environment1 = new EnvironmentDTO("Habitacion", 3, 2);
        EnvironmentDTO environment2 = new EnvironmentDTO("Cocina", 2, 4);
        EnvironmentDTO environment3 = new EnvironmentDTO("Baño", 2, 2);

        // RoomList initialize
        List<EnvironmentDTO> environment = new ArrayList<>();
        environment.add(environment1);
        environment.add(environment2);
        environment.add(environment3);

        // House initialize
        PropertyDTO inputHouse = new PropertyDTO("lacasa", environment, "Alberdi", 1000.0);

        String requestProperty = objectMapper.writeValueAsString(inputHouse);

        this.mockMvc.perform(
                post("/calculateTotalSquareMeters")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestProperty))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.name").value("MethodArgumentNotValidException"))
                .andExpect(jsonPath("$.description").value("The property name must begin with a capital letter."));
    }

    @Test
    void testCalculateTotalSquareMetersPropertyNameExceedsMax() throws Exception {
        // Arrange
        // Rooms initialize
        EnvironmentDTO environment1 = new EnvironmentDTO("Habitacion", 3, 2);
        EnvironmentDTO environment2 = new EnvironmentDTO("Cocina", 2, 4);
        EnvironmentDTO enviroment3 = new EnvironmentDTO("Baño", 2, 2);

        // RoomList initialize
        List<EnvironmentDTO> environment = new ArrayList<>();
        environment.add(environment1);
        environment.add(environment2);
        environment.add(enviroment3);

        // House initialize
        PropertyDTO inputProperty = new PropertyDTO("Lacasaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", environment, "Alberdi", 1000.0);

        String requestProperty = objectMapper.writeValueAsString(inputProperty);

        this.mockMvc.perform(
                post("/calculateTotalSquareMeters")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestProperty))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.name").value("MethodArgumentNotValidException"))
                .andExpect(jsonPath("$.description").value("The length of the property name cannot exceed 30 characters."));
    }

    @Test
    void testCalculateTotalSquareMetersBlankDistrictName() throws Exception {
        // Arrange
        // Rooms initialize
        EnvironmentDTO environment1 = new EnvironmentDTO("Habitacion", 3, 2);
        EnvironmentDTO environment2 = new EnvironmentDTO("Cocina", 2, 4);
        EnvironmentDTO environment3 = new EnvironmentDTO("Baño", 2, 2);

        // RoomList initialize
        List<EnvironmentDTO> environment = new ArrayList<>();
        environment.add(environment1);
        environment.add(environment2);
        environment.add(environment3);

        // House initialize
        PropertyDTO inputProperty = new PropertyDTO("Lacasa",
                environment,
                "",
                1000.0);

        String requestProperty = objectMapper.writeValueAsString(inputProperty);

        this.mockMvc.perform(
                post("/calculateTotalSquareMeters")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestProperty))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.name").value("MethodArgumentNotValidException"))
                .andExpect(jsonPath("$.description").value("The district cannot be empty."));
    }

    @Test
    void testCalculateTotalSquareMetersDistrictNameExceedsMax() throws Exception {
        // Arrange
        // Rooms initialize
        EnvironmentDTO environment1 = new EnvironmentDTO("Habitacion", 3, 2);
        EnvironmentDTO environment2 = new EnvironmentDTO("Cocina", 2, 4);
        EnvironmentDTO environment3 = new EnvironmentDTO("Baño", 2, 2);

        // RoomList initialize
        List<EnvironmentDTO> environment = new ArrayList<>();
        environment.add(environment1);
        environment.add(environment2);
        environment.add(environment3);

        // House initialize
        PropertyDTO inputProperty = new PropertyDTO("Lacasa",
                environment,
                "Alberdiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii",
                1000.0);

        String requestProperty = objectMapper.writeValueAsString(inputProperty);

        this.mockMvc.perform(
                post("/calculateTotalSquareMeters")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestProperty))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.name").value("MethodArgumentNotValidException"))
                .andExpect(jsonPath("$.description").value("The length of the district cannot exceed 45 characters."));
    }

    @Test
    void testCalculateTotalSquareMetersNullDistrictPrice() throws Exception {
        // Arrange
        // Rooms initialize
        EnvironmentDTO environment1 = new EnvironmentDTO("Habitacion", 3, 2);
        EnvironmentDTO environment2 = new EnvironmentDTO("Cocina", 2, 4);
        EnvironmentDTO environment3 = new EnvironmentDTO("Baño", 2, 2);

        // RoomList initialize
        List<EnvironmentDTO> environment = new ArrayList<>();
        environment.add(environment1);
        environment.add(environment2);
        environment.add(environment3);

        // House initialize
        PropertyDTO inputProperty = new PropertyDTO("Lacasa",
                environment,
                "Alberdi",
                null);

        String requestProperty = objectMapper.writeValueAsString(inputProperty);

        this.mockMvc.perform(
                post("/calculateTotalSquareMeters")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestProperty))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.name").value("MethodArgumentNotValidException"))
                .andExpect(jsonPath("$.description").value("the price of a district cannot be empty."));
    }

    @Test
    void testCalculateTotalSquareMetersDistrictPriceExceedsMax() throws Exception {
        // Arrange
        // Rooms initialize
        EnvironmentDTO environment1 = new EnvironmentDTO("Habitacion", 3, 2);
        EnvironmentDTO environment2 = new EnvironmentDTO("Cocina", 2, 4);
        EnvironmentDTO environment3 = new EnvironmentDTO("Baño", 2, 2);

        // RoomList initialize
        List<EnvironmentDTO> environment = new ArrayList<>();
        environment.add(environment1);
        environment.add(environment2);
        environment.add(environment3);

        // House initialize
        PropertyDTO inputProperty = new PropertyDTO("Lacasa",
                environment,
                "Alberdi",
                40010.0);

        String requestProperty = objectMapper.writeValueAsString(inputProperty);

        this.mockMvc.perform(
                post("/calculateTotalSquareMeters")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestProperty))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.name").value("MethodArgumentNotValidException"))
                .andExpect(jsonPath("$.description").value("The maximum price allowed per square meter cannot exceed $US4000."));
    }

    @Test
    void testCalculateTotalSquareMetersBlankEnvironmentName() throws Exception {
        // Arrange
        // Rooms initialize
        EnvironmentDTO environment1 = new EnvironmentDTO("", 3, 2);
        EnvironmentDTO environment2 = new EnvironmentDTO("Cocina", 2, 4);
        EnvironmentDTO environment3 = new EnvironmentDTO("Baño", 2, 2);

        // RoomList initialize
        List<EnvironmentDTO> environment = new ArrayList<>();
        environment.add(environment1);
        environment.add(environment2);
        environment.add(environment3);

        // House initialize
        PropertyDTO inputProperty = new PropertyDTO("Lacasa",
                environment,
                "Alberdi",
                1000.0);

        String requestProperty = objectMapper.writeValueAsString(inputProperty);

        this.mockMvc.perform(
                post("/calculateTotalSquareMeters")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestProperty))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.name").value("MethodArgumentNotValidException"))
                .andExpect(jsonPath("$.description").value("The environment name cannot be empty."));
    }

    @Test
    void testCalculateTotalSquareMetersEnvironmentNameFirstLetterLowerCase() throws Exception {
        // Arrange
        // Rooms initialize
        EnvironmentDTO environment1 = new EnvironmentDTO("habitacion", 3, 2);
        EnvironmentDTO environment2 = new EnvironmentDTO("Cocina", 2, 4);
        EnvironmentDTO environment3 = new EnvironmentDTO("Baño", 2, 2);

        // RoomList initialize
        List<EnvironmentDTO> environment = new ArrayList<>();
        environment.add(environment1);
        environment.add(environment2);
        environment.add(environment3);

        // House initialize
        PropertyDTO inputProperty = new PropertyDTO("Lacasa",
                environment,
                "Alberdi",
                1000.0);

        String requestProperty = objectMapper.writeValueAsString(inputProperty);

        this.mockMvc.perform(
                post("/calculateTotalSquareMeters")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestProperty))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.name").value("MethodArgumentNotValidException"))
                .andExpect(jsonPath("$.description").value("The environment name must begin with a capital letter."));
    }

    @Test
    void testCalculateTotalSquareMetersEnvironmentNameExceedsMax() throws Exception {
        // Arrange
        // Rooms initialize
        EnvironmentDTO environment1 = new EnvironmentDTO("Habitacioooooooooooooooooooooooon", 3, 2);
        EnvironmentDTO environment2 = new EnvironmentDTO("Cocina", 2, 4);
        EnvironmentDTO environment3 = new EnvironmentDTO("Baño", 2, 2);

        // RoomList initialize
        List<EnvironmentDTO> environment = new ArrayList<>();
        environment.add(environment1);
        environment.add(environment2);
        environment.add(environment3);

        // House initialize
        PropertyDTO inputProperty = new PropertyDTO("Lacasa",
                environment,
                "Alberdi",
                1000.0);

        String requestProperty = objectMapper.writeValueAsString(inputProperty);

        this.mockMvc.perform(
                post("/calculateTotalSquareMeters")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestProperty))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.name").value("MethodArgumentNotValidException"))
                .andExpect(jsonPath("$.description").value("The length of the environment name cannot exceed 30 characters"));
    }

    @Test
    void testCalculateTotalSquareMetersNullEnvironmentWidth() throws Exception {
        // Arrange
        // Rooms initialize
        EnvironmentDTO environment1 = new EnvironmentDTO("Habitacion", null, 2);
        EnvironmentDTO environment2 = new EnvironmentDTO("Cocina", 2, 4);
        EnvironmentDTO environment3 = new EnvironmentDTO("Baño", 2, 2);

        // RoomList initialize
        List<EnvironmentDTO> environment = new ArrayList<>();
        environment.add(environment1);
        environment.add(environment2);
        environment.add(environment3);

        // House initialize
        PropertyDTO inputProperty = new PropertyDTO("Lacasa",
                environment,
                "Alberdi",
                1000.0);

        String requestProperty = objectMapper.writeValueAsString(inputProperty);

        this.mockMvc.perform(
                post("/calculateTotalSquareMeters")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestProperty))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.name").value("MethodArgumentNotValidException"))
                .andExpect(jsonPath("$.description").value("The environment widht cannot be empty."));
    }

    @Test
    void testCalculateTotalSquareMetersEnvironmentWidthExceedsMax() throws Exception {
        // Arrange
        // Rooms initialize
        EnvironmentDTO environment1 = new EnvironmentDTO("Habitacion", 30, 2);
        EnvironmentDTO environment2 = new EnvironmentDTO("Cocina", 2, 4);
        EnvironmentDTO environment3 = new EnvironmentDTO("Baño", 2, 2);

        // RoomList initialize
        List<EnvironmentDTO> environment = new ArrayList<>();
        environment.add(environment1);
        environment.add(environment2);
        environment.add(environment3);

        // House initialize
        PropertyDTO inputProperty = new PropertyDTO("Lacasa",
                environment,
                "Alberdi",
                1000.0);

        String requestProperty = objectMapper.writeValueAsString(inputProperty);

        this.mockMvc.perform(
                post("/calculateTotalSquareMeters")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestProperty))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.name").value("MethodArgumentNotValidException"))
                .andExpect(jsonPath("$.description").value("The maximum width allowed per property is 25 meters."));
    }

    @Test
    void testCalculateTotalSquareMetersNullEnvironmentLength() throws Exception {
        // Arrange
        // Rooms initialize
        EnvironmentDTO environment1 = new EnvironmentDTO("Habitacion", 3, null);
        EnvironmentDTO environment2 = new EnvironmentDTO("Cocina", 2, 4);
        EnvironmentDTO environment3 = new EnvironmentDTO("Baño", 2, 2);

        // RoomList initialize
        List<EnvironmentDTO> environment = new ArrayList<>();
        environment.add(environment1);
        environment.add(environment2);
        environment.add(environment3);

        // House initialize
        PropertyDTO inputProperty = new PropertyDTO("Lacasa",
                environment,
                "Alberdi",
                1000.0);

        String requestProperty = objectMapper.writeValueAsString(inputProperty);

        this.mockMvc.perform(
                post("/calculateTotalSquareMeters")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestProperty))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.name").value("MethodArgumentNotValidException"))
                .andExpect(jsonPath("$.description").value("The environment lenght cannot be empty."));
    }

    @Test
    void testCalculateTotalSquareMetersEnvironmentLengthExceedsMax() throws Exception {
        // Arrange
        // Rooms initialize
        EnvironmentDTO environment1 = new EnvironmentDTO("Habitacion", 3, 34);
        EnvironmentDTO environment2 = new EnvironmentDTO("Cocina", 2, 4);
        EnvironmentDTO environment3 = new EnvironmentDTO("Baño", 2, 2);

        // RoomList initialize
        List<EnvironmentDTO> environment = new ArrayList<>();
        environment.add(environment1);
        environment.add(environment2);
        environment.add(environment3);

        // House initialize
        PropertyDTO inputProperty = new PropertyDTO("Lacasa",
                environment,
                "Alberdi",
                1000.0);

        String requestProperty = objectMapper.writeValueAsString(inputProperty);

        this.mockMvc.perform(
                post("/calculateTotalSquareMeters")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestProperty))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.name").value("MethodArgumentNotValidException"))
                .andExpect(jsonPath("$.description").value("The maximum width allowed per property is 33 meters."));
    }
}
