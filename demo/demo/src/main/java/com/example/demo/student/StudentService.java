package com.example.demo.student;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;


// This is the service layer of the application
// This class is used to handle the business logic
// This class is used to interact with the repository layer


@Service
public class StudentService {


    private  final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents() {
        return  studentRepository.findAll();
    }

    public void addNewStudent(Student student) {

        Optional<Student> studentOptional =
                studentRepository.findStudentByEmail(student.getEmail());

        if(studentOptional.isPresent()){
            throw new IllegalStateException("email taken");
        }
//        System.out.println(student);
        studentRepository.save(student);
    }

    public void deleteStudent(Long studentId) {
        boolean exists = studentRepository.existsById(studentId);
        if(!exists){
            throw new IllegalStateException(
                    "student with id " + studentId + " does not exists"
            );
        }
        studentRepository.deleteById(studentId);
    }

    @Transactional
    public void updateStudent(Long studentId, String name, String email) {

        Student student  = studentRepository.findById(studentId).orElseThrow(()-> new IllegalStateException(
                "student with id " + studentId + " does not exists"
        ));

        if(name != null && name.length() >0 && !student.getName().equals(name)){
            student.setName(name);
        }

        if(email != null && email.length()>0 && !student.getEmail().equals(email)){
            Optional<Student> studentOptional = studentRepository.findStudentByEmail(email);
            if(studentOptional.isPresent()){
                throw new IllegalStateException("email already taken . try another one ");
            }
            student.setEmail(email);
        }
    }
}
