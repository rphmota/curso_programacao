package com.rphmota.cursos_programacao.modules.course.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

import com.rphmota.cursos_programacao.modules.course.entities.Course;
import com.rphmota.cursos_programacao.modules.course.useCases.CreateCourseUseCase;
import com.rphmota.cursos_programacao.modules.course.useCases.DeleteCourseUseCase;
import com.rphmota.cursos_programacao.modules.course.useCases.ListCourseUseCase;


@RestController
@RequestMapping("/course")
public class CourseController {
  
  @Autowired
  private CreateCourseUseCase createCourseUseCase;

  @Autowired
  private DeleteCourseUseCase deleteCourseUseCase;

  @Autowired
  private ListCourseUseCase listCourseUseCase;


  @PostMapping()
  public ResponseEntity<Object> create(@Valid @RequestBody Course course){
    try{
      var result = this.createCourseUseCase.execute(course);
      return ResponseEntity.ok().body(result);
    }catch (Exception e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    }
  }

  @DeleteMapping("/{uuid}")
  public ResponseEntity<Object> delete(@PathVariable UUID uuid){
    try {
      deleteCourseUseCase.execute(uuid); // Executando a deleção
      return ResponseEntity.ok().build(); // Retorna resposta 200 OK sem corpo, indicando sucesso
    } catch (Exception e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    }
  }

  @GetMapping
  public List<Course> findJobByFilter(@RequestParam(required = false, defaultValue = "") String filter) {
    return this.listCourseUseCase.execute(filter);
}
}
