package com.rphmota.cursos_programacao.modules.course;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course,UUID> {
  
}
