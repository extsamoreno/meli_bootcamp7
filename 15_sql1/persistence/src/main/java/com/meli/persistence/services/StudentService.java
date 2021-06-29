package com.meli.persistence.services;

import com.meli.persistence.dtos.StudentDTO;
import com.meli.persistence.dtos.StudentsDTO;
import com.meli.persistence.repositories.IStudentRepository;
import com.meli.persistence.repositories.entities.StudentEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService implements IStudentService {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    IStudentRepository studentRepo;

    @Override
    public String add(StudentDTO studentDto) {

        StudentEntity newStudent = mapper.map(studentDto, StudentEntity.class);
        studentRepo.save(newStudent);
        return "Student Added successfully";
    }

    public StudentService(IStudentRepository studentRepo) {
        this.studentRepo = studentRepo;
    }

    @Override
    public StudentsDTO getAll(int page, int perPage) {
        Integer count = Math.toIntExact(studentRepo.count());
        System.out.println("count = " + count);
        Pageable sortedByName = PageRequest.of(page, perPage, Sort.by("name"));
        List<StudentEntity> students = studentRepo.findAll(sortedByName).getContent();

        List<StudentDTO>  studentDTOList = StudentsMapperEntityToDto(students);
        System.out.println("students = " + students.toString());

        return new StudentsDTO(count, page, perPage, studentDTOList);
    }

    private List<StudentDTO> StudentsMapperEntityToDto(List<StudentEntity> students){
        List<StudentDTO> studentDTOList = new ArrayList<>();
        for(StudentEntity s:students){
            StudentDTO newStudent = mapper.map(s, StudentDTO.class);
            studentDTOList.add(newStudent);
        }
        return studentDTOList;
    }
}
