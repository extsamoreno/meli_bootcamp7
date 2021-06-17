package com.example.desafio2.utils;

import com.example.desafio2.dtos.ResponseEnvironmentDTO;
import com.example.desafio2.models.EnvironmentDTO;
import com.example.desafio2.models.NeighborhoodDTO;
import com.example.desafio2.models.PropertyDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class TestUtilsGenerator {

    private static String SCOPE;
    private static ObjectWriter mapper;

    public static void emptyFiles() {
        Properties properties = new Properties();

        try {
            properties.load(new ClassPathResource("application.properties").getInputStream());
            SCOPE = properties.getProperty("api.scope");
        } catch (IOException e) {
            e.printStackTrace();
        }

        PrintWriter writerProperty = null;
        PrintWriter writerNeighborhood = null;

        try {
            writerProperty = new PrintWriter(ResourceUtils.getFile("./src/" + SCOPE + "/resources/properties.json"));
            writerNeighborhood = new PrintWriter(ResourceUtils.getFile("./src/" + SCOPE + "/resources/neighborhoods.json"));
        } catch (
                IOException e) {
            e.printStackTrace();
        }

        assert writerProperty != null;
        writerProperty.print("[]");
        assert writerNeighborhood != null;
        writerNeighborhood.print("[]");
        writerProperty.close();
        writerNeighborhood.close();
    }

    public static PropertyDTO getPropertyWith305SquareMeters(String name) {
        EnvironmentDTO environment1 = new EnvironmentDTO("Habitación 1", 8.0, 33.0);
        EnvironmentDTO environment2 = new EnvironmentDTO("Habitación 2", 25.0, 1.0);
        EnvironmentDTO environment3 = new EnvironmentDTO("Habitación 3", 4.0, 4.0);

        List<EnvironmentDTO> environments = new ArrayList<>();
        environments.add(environment1);
        environments.add(environment2);
        environments.add(environment3);

        PropertyDTO property = new PropertyDTO();
        int id = 9999;
        String address = "Av. Los Colibries 123";
        String neighborhood = "Liniers";
        property.setId(id);
        property.setName(name);
        property.setAddress(address);
        property.setNeighborhood(neighborhood);
        property.setEnvironments(environments);

        return property;
    }

    public static NeighborhoodDTO getNeighborhoodPriceTen(String name) {
        NeighborhoodDTO neighborhood = new NeighborhoodDTO();

        int id = 9999;
        Double price = 10.00;

        neighborhood.setId(id);
        neighborhood.setName(name);
        neighborhood.setPrice(price);

        return neighborhood;
    }

    public static EnvironmentDTO getEnvironment264SquareMeters(String name) {
        EnvironmentDTO environment = new EnvironmentDTO(name, 8.0, 33.0);

        Double width = 8.00;
        Double length = 33.00;

        environment.setName(name);
        environment.setWidth(width);
        environment.setLength(length);

        return environment;
    }

    public static List<ResponseEnvironmentDTO> getEnvironmentSquareMetersList(PropertyDTO property) {
        List<ResponseEnvironmentDTO> list = new ArrayList<>();
        ResponseEnvironmentDTO environment;

        for(EnvironmentDTO env : property.getEnvironments()) {
            environment = new ResponseEnvironmentDTO(env.getName(), env.getLength() * env.getWidth());
            list.add(environment);
        }

        return list;
    }

    public static void appendNewProperty(PropertyDTO property) {
        mapper = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer().withDefaultPrettyPrinter();

        PrintWriter writer = null;

        try {
            String content = Files.readString(new File("./src/" + SCOPE + "/resources/properties.json").getAbsoluteFile().toPath(), StandardCharsets.US_ASCII);
            writer = new PrintWriter(ResourceUtils.getFile("./src/" + SCOPE + "/resources/properties.json"));

            try {
                String studentAsString = mapper.writeValueAsString(property);
                writer.print(content.substring(0, content.length()-1));
                if (content.length()>2) writer.print(", ");
                writer.print(studentAsString);
                writer.print("]");
            } catch (JsonProcessingException jsonProcessingException) {
                jsonProcessingException.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        assert writer != null;
        writer.close();
    }


    /*
    public static StudentDTO getStudentWith3SubjectsAverageOver9(String name) {
        SubjectDTO subject1 = new SubjectDTO("Matemática", 8.0);
        SubjectDTO subject2 = new SubjectDTO("Lengua", 9.0);
        SubjectDTO subject3 = new SubjectDTO("Física", 10.0);

        List<SubjectDTO> subjects = new ArrayList<>();
        subjects.add(subject1);
        subjects.add(subject2);
        subjects.add(subject3);

        StudentDTO stu = new StudentDTO();
        stu.setId(9999L);
        stu.setStudentName(name);
        stu.setSubjects(subjects);

        return stu;
    }

    public static StudentDTO getStudentWithId(Long id) {
        SubjectDTO subject1 = new SubjectDTO("Matemática", 8.0);
        SubjectDTO subject2 = new SubjectDTO("Lengua", 6.0);
        SubjectDTO subject3 = new SubjectDTO("Física", 4.0);

        List<SubjectDTO> subjects = new ArrayList<>();
        subjects.add(subject1);
        subjects.add(subject2);
        subjects.add(subject3);

        StudentDTO stu = new StudentDTO();
        stu.setId(id);
        stu.setStudentName("student1");
        stu.setSubjects(subjects);

        return stu;
    }

    public static Set<StudentDTO> getStudentSet() {
        StudentDTO stu1 = getStudentWith3Subjects("Marco");
        StudentDTO stu2 = getStudentWith3Subjects("Marco Polo");
        StudentDTO stu3 = getStudentWith3Subjects("Julio");
        StudentDTO stu4 = getStudentWith3Subjects("Julio Cesar");

        return new HashSet<StudentDTO>(){{add(stu1); add(stu2); add(stu3); add(stu4);}};
    }
 */
}
