package com.example.demo.student;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

// This is the repository layer of the application
// This class is used to interact with the database
// This class is used to perform the CRUD operations
// This class provides all the methods to interact with the database

@Repository
public interface StudentRepository // This interface is used to interact with the database.

        extends JpaRepository<Student, Long> {

//    @Query("SELECT s FROM Student s WHERE s.email = ?1")
    Optional<Student> findStudentByEmail(String email);

}


