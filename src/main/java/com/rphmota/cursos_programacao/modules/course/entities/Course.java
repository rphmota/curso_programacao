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

  public void updateName(String name) {
    if (name != null && !name.trim().isEmpty()) {
        this.name = name;
    }
  }

  // Método para atualizar a categoria, se o valor for válido
  public void updateCategory(String category) {
      if (category != null && !category.trim().isEmpty()) {
          this.category = category;
      }
  }

  
  
}
