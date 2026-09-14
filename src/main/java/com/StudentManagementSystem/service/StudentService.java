package com.StudentManagementSystem.service;

import com.StudentManagementSystem.entity.Student;
import com.StudentManagementSystem.repository.StudentRepository;
import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {
                List<Student> getAllStudents();

                Student saveStudent(Student student);
                Student getStudentById(Integer id);
                Student updateStudent(Student existingStd);

                Student createNewStudent(Student student);
                Student deleteStudentById(int id);
                Student editStudent(Student student);
        }

