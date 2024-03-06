package com.rphmota.cursos_programacao.modules.course.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;
import com.rphmota.cursos_programacao.modules.course.entities.Course;
import com.rphmota.cursos_programacao.modules.course.useCases.CreateCourseUseCase;


@RestController
@RequestMapping("/course")
public class CourseController {
  
  @Autowired
  private CreateCourseUseCase createCourseUseCase;

  @PostMapping("/")
  public ResponseEntity<Object> create(@Valid @RequestBody Course course){
    try{
      var result = this.createCourseUseCase.execute(course);
      return ResponseEntity.ok().body(result);
    }catch (Exception e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    }
  }


}
