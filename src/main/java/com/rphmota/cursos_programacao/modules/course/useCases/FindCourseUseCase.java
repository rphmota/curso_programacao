package com.rphmota.cursos_programacao.modules.course.useCases;

import java.util.Optional;
import java.util.UUID;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import com.rphmota.cursos_programacao.modules.course.entities.Course;
import com.rphmota.cursos_programacao.modules.course.repositories.CourseRepository;

@Service
public class FindCourseUseCase {

private final CourseRepository courseRepository;

public FindCourseUseCase(CourseRepository courseRepository){
  this.courseRepository = courseRepository;
}

public Optional<Course> execute(UUID uuid) {
  if (uuid == null) {
    throw new IllegalArgumentException("UUID cannot be null. Please provide a valid UUID.");
  }
  return this.courseRepository.findById(uuid);
}

/* public Optional<Course> execute(@NonNull UUID uuid){
  return this.courseRepository.findById(uuid);
} */

}
