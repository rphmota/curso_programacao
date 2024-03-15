package com.rphmota.cursos_programacao.modules.course.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

import com.rphmota.cursos_programacao.modules.course.entities.Course;
import com.rphmota.cursos_programacao.modules.course.useCases.CreateCourseUseCase;
import com.rphmota.cursos_programacao.modules.course.useCases.DeleteCourseUseCase;
import com.rphmota.cursos_programacao.modules.course.useCases.FindCourseUseCase;
import com.rphmota.cursos_programacao.modules.course.useCases.ListCourseUseCase;
import com.rphmota.cursos_programacao.modules.course.useCases.UpdateCourseUseCase;


@RestController
@RequestMapping("/course")
public class CourseController {
  
  @Autowired
  private CreateCourseUseCase createCourseUseCase;

  @Autowired
  private DeleteCourseUseCase deleteCourseUseCase;

  @Autowired
  private ListCourseUseCase listCourseUseCase;

  @Autowired FindCourseUseCase findCourseUseCase;

  @Autowired
  private UpdateCourseUseCase updateCourseUseCase;



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
  public ResponseEntity<Object> delete(@PathVariable @NonNull UUID uuid){
    try {
      deleteCourseUseCase.execute(uuid); // Executando a deleção
      return ResponseEntity.ok().build(); // Retorna resposta 200 OK sem corpo, indicando sucesso
    } catch (Exception e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    }
  }

  @GetMapping
  public List<Course> findCourseByFilter(@RequestParam(required = false, defaultValue = "") String filter) {
    return this.listCourseUseCase.execute(filter);
  }
  
  @GetMapping("/{uuid}")
  public ResponseEntity<Object> indCourseById(@RequestParam UUID uuid) {
    try {
      var result = this.findCourseUseCase.execute(uuid);
      return ResponseEntity.ok().body(result);

    } catch (Exception e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    }
    
}
@PutMapping("/{uuid}")
  public ResponseEntity<Object> update(@PathVariable @NonNull UUID uuid, @Valid @RequestBody Course course){
    try {
      var updatedCourse = updateCourseUseCase.execute(uuid, course);
      return ResponseEntity.ok().body(updatedCourse);
    } catch (Exception e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    }
  }
}
