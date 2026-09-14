package com.StudentManagementSystem.studentServiceImpl;
import com.StudentManagementSystem.entity.Student;
import com.StudentManagementSystem.repository.StudentRepository;
import com.StudentManagementSystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

     @Autowired
     private StudentRepository studentRepository ;

    @Override
     public List<Student> getAllStudents(){
         return studentRepository.findAll();
     }

     @Override
     public Student createNewStudent(Student student){return studentRepository.save(student);}

     @Override
    public Student saveStudent(Student student){
        return studentRepository.save(student);
     }

    @Override
    public Student editStudent(Student student){
        return studentRepository.save(student);
    }

     @Override
    public Student getStudentById(Integer id){
        return studentRepository.findById(id).orElse(null);
     }

     @Override
     public Student updateStudent(Student student){
        return studentRepository.save(student);
     }

     @Override
    public Student deleteStudentById(int id){
        studentRepository.deleteById(id);
         return null;
     }

}
