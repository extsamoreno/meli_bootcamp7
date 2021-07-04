package com.randomstudent.demo.Repository;
import com.randomstudent.demo.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStudentRepository extends JpaRepository<Student, Long> {

    Student getStudentById(Long id);
}
