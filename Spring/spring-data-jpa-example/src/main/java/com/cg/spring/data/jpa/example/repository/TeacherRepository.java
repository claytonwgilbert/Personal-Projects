package com.cg.spring.data.jpa.example.repository;

import com.cg.spring.data.jpa.example.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
