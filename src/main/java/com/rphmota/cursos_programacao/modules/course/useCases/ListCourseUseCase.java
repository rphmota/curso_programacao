package com.rphmota.cursos_programacao.modules.course.useCases;

import java.util.List;
import org.springframework.stereotype.Service;
import com.rphmota.cursos_programacao.modules.course.entities.Course;
import com.rphmota.cursos_programacao.modules.course.repositories.CourseRepository;

@Service
public class ListCourseUseCase {

  private final CourseRepository courseRepository;

  public ListCourseUseCase(CourseRepository courseRepository) {
    this.courseRepository = courseRepository;
  }

  public List<Course> execute(String filter){    
    if (filter == null || filter.isEmpty()) {
      // Retorna todos os cursos se o filtro estiver vazio
      return courseRepository.findAll();
    } else {
      // Retorna cursos que correspondem ao filtro
      return courseRepository.findByNameContainingIgnoreCase(filter);
    }
  }
}
