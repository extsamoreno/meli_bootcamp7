package com.meli.API_diploma.service;

import com.meli.API_diploma.dto.DiplomaDTO;
import com.meli.API_diploma.entities.Course;
import com.meli.API_diploma.entities.Student;

import java.util.ArrayList;

public class DataBase {
    public static ArrayList<Student> students = new ArrayList<>();

    public static void addStudent(Student student) { DataBase.students.add(student);}

    public static float generateAverageFromCourses(String name) {
        float average = 0;
        int counter = 0;
        for (Student student: DataBase.students) {
            if ( student.getName().equals(name) ) {
                ArrayList<Course> courses = student.getCourses();
                for (int i = 0; i < courses.size(); i++) {
                    Course course = courses.get(i);
                    average = average + course.getScore();
                    counter++;
                }
            }
        }
        return (average/counter);
    }

    public static DiplomaDTO generateDiploma(String name) {
        DiplomaDTO diplomaDTO = null;
        for (Student student: DataBase.students) {
            if ( student.getName().equals(name)) {
                float average = generateAverageFromCourses(name);
                diplomaDTO = new DiplomaDTO(name, average);
                if (average > 9) {
                    diplomaDTO.setCongratulations("!!Congratulations for your great effort, you are an example of Excellence¡¡");
                }
                return diplomaDTO;



            }
        }
        return null;
    }
}
