package com.rphmota.cursos_programacao.modules.course.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "course")
public class Course {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;


  private String name;

  private String category;

  private Boolean active;

  private LocalDateTime createdAt;
  
  private LocalDateTime updatedAt;

  
  
}
