package com.rphmota.cursos_programacao.exceptions;

public class CourseFoundException extends RuntimeException {
  public CourseFoundException(){
    super("Curso com esse nome ja existe");
  }
}
