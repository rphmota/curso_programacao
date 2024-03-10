package com.rphmota.cursos_programacao.modules.course.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rphmota.cursos_programacao.modules.course.entities.Course;
import java.util.List;


public interface CourseRepository extends JpaRepository<Course,UUID>{
  Optional<Course>  findByName(String name);

  List<Course> findByNameContainingIgnoreCase(String filter);

  List<Course> findByCategory(String category);

  
}
