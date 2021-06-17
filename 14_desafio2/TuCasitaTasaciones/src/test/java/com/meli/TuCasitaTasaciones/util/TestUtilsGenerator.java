package com.meli.TuCasitaTasaciones.util;

import com.meli.TuCasitaTasaciones.model.*;

import java.util.*;

public class TestUtilsGenerator {
    private Set<PropertyDTO> properties = new HashSet<>();
    private HashMap<String, Double> districts = new HashMap<>();

    public static PropertyDTO getPropertyDTO() {
        District district1 = new District("Palermo", 5000);
        EnvironmentDTO environmentDTO1 = new EnvironmentDTO("Room1", 18, 18);
        EnvironmentDTO environmentDTO2 = new EnvironmentDTO("Room2", 10, 12);
        EnvironmentDTO environmentDTO3 = new EnvironmentDTO("kitchen", 15, 20);
        EnvironmentDTO environmentDTO4 = new EnvironmentDTO("Toilet", 11, 5);
        EnvironmentDTO environmentDTO5 = new EnvironmentDTO("Hall", 20, 20);

        List<EnvironmentDTO> environments1 = new ArrayList<>();
        environments1.add(environmentDTO1);
        environments1.add(environmentDTO2);
        environments1.add(environmentDTO3);
        environments1.add(environmentDTO4);
        environments1.add(environmentDTO5);

        PropertyDTO pro1 = new PropertyDTO("Casa 1", district1, environments1);

        return pro1;
    }

    public static List<EnvironmentDTO> getEnvironments() {
        EnvironmentDTO environmentDTO1 = new EnvironmentDTO("Room1", 18, 18);
        EnvironmentDTO environmentDTO2 = new EnvironmentDTO("Room2", 10, 12);
        EnvironmentDTO environmentDTO3 = new EnvironmentDTO("kitchen", 15, 20);
        EnvironmentDTO environmentDTO4 = new EnvironmentDTO("Toilet", 11, 5);
        EnvironmentDTO environmentDTO5 = new EnvironmentDTO("Hall", 20, 21);

        List<EnvironmentDTO> environments1 = new ArrayList<>();
        environments1.add(environmentDTO1);
        environments1.add(environmentDTO2);
        environments1.add(environmentDTO3);
        environments1.add(environmentDTO4);
        environments1.add(environmentDTO5);

        return environments1;
    }

    public static HouseDTO getHouseDTO() {

        EnvironmentDTO environmentDTO1 = new EnvironmentDTO("Room1", 18, 18);
        EnvironmentDTO environmentDTO2 = new EnvironmentDTO("Room2", 10, 12);
        EnvironmentDTO environmentDTO3 = new EnvironmentDTO("kitchen", 15, 20);
        EnvironmentDTO environmentDTO4 = new EnvironmentDTO("Toilet", 11, 5);
        EnvironmentDTO environmentDTO5 = new EnvironmentDTO("Hall", 20, 20);


        List<EnvironmentDTO> environments1 = new ArrayList<>();
        environments1.add(environmentDTO1);
        environments1.add(environmentDTO2);
        environments1.add(environmentDTO3);
        environments1.add(environmentDTO4);
        environments1.add(environmentDTO5);

        HouseDTO h = new HouseDTO("Palermo", environments1);

        return h;
    }

    public static EnvironmentDTO getEnvironmentDTO() {
        EnvironmentDTO e = new EnvironmentDTO("Hall", 20, 21);
        return e;
    }

    public static EnvironmentAreaResponseDTO getEnvironmentAreaResponseDTO() {
        EnvironmentAreaResponseDTO e = new EnvironmentAreaResponseDTO("Hall", 20, 21, 420);
        return e;
    }

    public static List<EnvironmentAreaResponseDTO> getListEnvironmentAreaResponseDTO() {
        List<EnvironmentAreaResponseDTO> l = new ArrayList<>();
        EnvironmentAreaResponseDTO environmentDTO1 = new EnvironmentAreaResponseDTO("Room1", 18, 18, 324 );
        EnvironmentAreaResponseDTO environmentDTO2 = new EnvironmentAreaResponseDTO("Room2", 10, 12, 120);
        EnvironmentAreaResponseDTO environmentDTO3 = new EnvironmentAreaResponseDTO("kitchen", 15, 20, 300);
        EnvironmentAreaResponseDTO environmentDTO4 = new EnvironmentAreaResponseDTO("Toilet", 11, 5, 55);
        EnvironmentAreaResponseDTO environmentDTO5 = new EnvironmentAreaResponseDTO("Hall", 20, 21, 420);

        l.add(environmentDTO1);
        l.add(environmentDTO2);
        l.add(environmentDTO3);
        l.add(environmentDTO4);
        l.add(environmentDTO5);

        return l;
    }

    public static HashMap<String, Double> getDistrictsList() {

        District district1 = new District("Palermo", 5000);
        District district2 = new District("Centro", 2000);
        District district3 = new District("Martires", 1000);

        HashMap<String, Double> districts = new HashMap<>();

        districts.put(district1.getDistrictName(), district1.getPrice());
        districts.put(district2.getDistrictName(), district2.getPrice());
        districts.put(district3.getDistrictName(), district3.getPrice());
        return districts;
    }

    public static Set<PropertyDTO> getPropertyDTerwerwO() {
        District district1 = new District("Palermo", 5000);
        District district2 = new District("Centro", 2000);
        District district3 = new District("Martires", 1000);

        EnvironmentDTO environmentDTO1 = new EnvironmentDTO("Room1", 18, 18);
        EnvironmentDTO environmentDTO2 = new EnvironmentDTO("Room2", 10, 12);
        EnvironmentDTO environmentDTO3 = new EnvironmentDTO("kitchen", 15, 20);
        EnvironmentDTO environmentDTO4 = new EnvironmentDTO("Toilet", 11, 5);
        EnvironmentDTO environmentDTO5 = new EnvironmentDTO("Hall", 20, 20);

        List<EnvironmentDTO> environments1 = new ArrayList<>();
        environments1.add(environmentDTO1);
        environments1.add(environmentDTO2);
        environments1.add(environmentDTO3);
        environments1.add(environmentDTO4);
        environments1.add(environmentDTO5);

        List<EnvironmentDTO> environments2 = new ArrayList<>();
        environments2.add(environmentDTO1);
        environments2.add(environmentDTO3);
        environments2.add(environmentDTO4);

        List<EnvironmentDTO> environments3 = new ArrayList<>();
        environments3.add(environmentDTO2);
        environments3.add(environmentDTO4);

        PropertyDTO pro1 = new PropertyDTO("Casa 1", district1, environments1);

        PropertyDTO pro2 = new PropertyDTO("Casa 2", district2, environments2);
        PropertyDTO pro3 = new PropertyDTO("Casa 3", district3, environments3);


        Set<PropertyDTO> properties = new HashSet<>();
        properties.add(pro1);
        properties.add(pro2);
        properties.add(pro3);

        HashMap<String, Double> districts = new HashMap<>();

        districts.put(district1.getDistrictName(), district1.getPrice());
        districts.put(district2.getDistrictName(), district2.getPrice());
        districts.put(district3.getDistrictName(), district3.getPrice());
        return null;
    }

}
//
//    private static String SCOPE;
//    private static ObjectWriter mapper;
//
//    public static void emptyUsersFile() {
//        Properties properties = new Properties();
//
//        try {
//            properties.load(new ClassPathResource("application.properties").getInputStream());
//            SCOPE = properties.getProperty("api.scope");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        PrintWriter writer = null;
//
//        try {
//            writer = new PrintWriter(ResourceUtils.getFile("./src/" + SCOPE + "/resources/users.json"));
//        } catch (
//                IOException e) {
//            e.printStackTrace();
//        }
//
//        writer.print("[]");
//        writer.close();
//    }
//
//    public static StudentDTO getStudentWith3Subjects(String name) {
//        SubjectDTO subject1 = new SubjectDTO("Matemática", 8.0);
//        SubjectDTO subject2 = new SubjectDTO("Lengua", 6.0);
//        SubjectDTO subject3 = new SubjectDTO("Física", 4.0);
//
//        List<SubjectDTO> subjects = new ArrayList<>();
//        subjects.add(subject1);
//        subjects.add(subject2);
//        subjects.add(subject3);
//
//        StudentDTO stu = new StudentDTO();
//        stu.setId(9999L);
//        stu.setStudentName(name);
//        stu.setSubjects(subjects);
//
//        return stu;
//    }
//
//    public static StudentDTO getStudentWith3SubjectsAverageOver9(String name) {
//        SubjectDTO subject1 = new SubjectDTO("Matemática", 8.0);
//        SubjectDTO subject2 = new SubjectDTO("Lengua", 9.0);
//        SubjectDTO subject3 = new SubjectDTO("Física", 10.0);
//
//        List<SubjectDTO> subjects = new ArrayList<>();
//        subjects.add(subject1);
//        subjects.add(subject2);
//        subjects.add(subject3);
//
//        StudentDTO stu = new StudentDTO();
//        stu.setId(9999L);
//        stu.setStudentName(name);
//        stu.setSubjects(subjects);
//
//        return stu;
//    }
//
//    public static StudentDTO getMyStudent(String name) {
//        SubjectDTO subject1 = new SubjectDTO("Matemática", 10.0);
//        SubjectDTO subject2 = new SubjectDTO("Física", 8.0);
//        SubjectDTO subject3 = new SubjectDTO("Química", 4.0);
//
//        List<SubjectDTO> subjects = new ArrayList<>();
//        subjects.add(subject1);
//        subjects.add(subject2);
//        subjects.add(subject3);
//
//        StudentDTO stu = new StudentDTO();
//        stu.setId(2L);
//        stu.setStudentName(name);
//        stu.setSubjects(subjects);
//        stu.setMessage("El alumno "+stu.getStudentName()+" ha obtenido un promedio de 7,33. Puedes mejorar.");
//        stu.setAverageScore(7.333333333333333);
//
//        return stu;
//    }
//
//    public static StudentDTO getStudentWithId(Long id) {
//        SubjectDTO subject1 = new SubjectDTO("Matemática", 8.0);
//        SubjectDTO subject2 = new SubjectDTO("Lengua", 6.0);
//        SubjectDTO subject3 = new SubjectDTO("Física", 4.0);
//
//        List<SubjectDTO> subjects = new ArrayList<>();
//        subjects.add(subject1);
//        subjects.add(subject2);
//        subjects.add(subject3);
//
//        StudentDTO stu = new StudentDTO();
//        stu.setId(id);
//        stu.setStudentName("student1");
//        stu.setSubjects(subjects);
//
//        return stu;
//    }
//
//    public static Set<StudentDTO> getStudentSet() {
//        StudentDTO stu1 = getStudentWith3Subjects("Marco");
//        StudentDTO stu2 = getStudentWith3Subjects("Marco Polo");
//        StudentDTO stu3 = getStudentWith3Subjects("Julio");
//        StudentDTO stu4 = getStudentWith3Subjects("Julio Cesar");
//
//        return new HashSet<StudentDTO>(){{add(stu1); add(stu2); add(stu3); add(stu4);}};
//    }
//
//    public static void appendNewStudent(StudentDTO stu) {
//        mapper = new ObjectMapper()
//                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
//                .writer().withDefaultPrettyPrinter();
//
//        PrintWriter writer = null;
//
//        try {
//            String content = Files.readString(new File("./src/" + SCOPE + "/resources/users.json").getAbsoluteFile().toPath(), StandardCharsets.US_ASCII);
//            writer = new PrintWriter(ResourceUtils.getFile("./src/" + SCOPE + "/resources/users.json"));
//
//            try {
//                String studentAsString = mapper.writeValueAsString(stu);
//                writer.print(content.substring(0, content.length()-1));
//                if (content.length()>2) writer.print(", ");
//                writer.print(studentAsString);
//                writer.print("]");
//            } catch (JsonProcessingException jsonProcessingException) {
//                jsonProcessingException.printStackTrace();
//            }
//        }
//        catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        writer.close();
//    }

//}
