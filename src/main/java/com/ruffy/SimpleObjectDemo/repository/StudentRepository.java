package com.ruffy.SimpleObjectDemo.repository;

import com.ruffy.SimpleObjectDemo.model.StudentObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<StudentObject, Integer> { }
