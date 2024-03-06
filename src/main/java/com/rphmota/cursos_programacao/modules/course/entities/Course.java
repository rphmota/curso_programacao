package com.rphmota.cursos_programacao.modules.course.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

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

  @CreationTimestamp
  private LocalDateTime createdAt;
  
  @CreationTimestamp
  private LocalDateTime updatedAt;

  
  
}
