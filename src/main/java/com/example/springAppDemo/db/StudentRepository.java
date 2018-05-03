package com.example.springAppDemo.db;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by bla on 19/04/2018.
 */
public interface StudentRepository  extends JpaRepository<Student, Long> {
}
