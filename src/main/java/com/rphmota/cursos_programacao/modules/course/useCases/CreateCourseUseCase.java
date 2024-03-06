package com.rphmota.cursos_programacao.modules.course.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rphmota.cursos_programacao.exceptions.CourseFoundException;
import com.rphmota.cursos_programacao.modules.course.entities.Course;
import com.rphmota.cursos_programacao.modules.course.repositories.CourseRepository;

@Service
public class CreateCourseUseCase {
  
  @Autowired
  private CourseRepository courseRepository;

  public Course execute(Course course){
    
    this.courseRepository.findByName(course.getName())
    .ifPresent(course_ -> {
      throw new CourseFoundException();
    });

    this.courseRepository.save(course);
    
    return course;
  }


}
