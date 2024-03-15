package com.rphmota.cursos_programacao.modules.course.useCases;
import org.springframework.lang.NonNull;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rphmota.cursos_programacao.exceptions.CourseNotFoundException;
import com.rphmota.cursos_programacao.modules.course.entities.Course;
import com.rphmota.cursos_programacao.modules.course.repositories.CourseRepository;

@Service
public class UpdateCourseUseCase {
  
  @Autowired
  private CourseRepository courseRepository;

  public Course execute(@NonNull UUID id, Course updatedCourse) {
    // Busca o curso existente ou lança uma exceção se não encontrado
    Course existingCourse = this.courseRepository.findById(id)
      .orElseThrow(CourseNotFoundException::new);
    
    // Atualiza os campos desejados do curso existente
    existingCourse.updateName(updatedCourse.getName());
    existingCourse.updateCategory(updatedCourse.getCategory());

    // Salva as alterações no curso
    this.courseRepository.save(existingCourse);
    
    return existingCourse;
  }
}
