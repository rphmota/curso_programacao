package com.rphmota.cursos_programacao.modules.course.useCases;

import java.util.UUID;
import org.springframework.lang.NonNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rphmota.cursos_programacao.exceptions.CourseNotFoundException;
import com.rphmota.cursos_programacao.modules.course.entities.Course;
import com.rphmota.cursos_programacao.modules.course.repositories.CourseRepository;

@Service
public class DeleteCourseUseCase {


    @Autowired
    private CourseRepository courseRepository;

    public void execute(@NonNull UUID courseId) {
        // Verifica se o curso existe antes de tentar deletá-lo
        Course course = this.courseRepository.findById(courseId)
        //Essa construcao remete as lambdas do java ::new
        .orElseThrow(CourseNotFoundException::new);      

        // Se o curso existir, procede com a deleção
        this.courseRepository.delete(course);
        /*
         * forma mais verbosa
         * 
         *  // Tenta encontrar o curso pelo ID
            Optional<Course> courseOptional = courseRepository.findById(courseId);
        
            // Verifica se um curso foi encontrado
            if (!courseOptional.isPresent()) {
                // Lança a exceção de forma explícita se o curso não for encontrado
                throw new CourseNotFoundException();
            }
        
            // Se o curso existir, recupera o curso do Optional e procede com a deleção
            Course course = courseOptional.get();
            courseRepository.delete(course);
         */
    }
}
