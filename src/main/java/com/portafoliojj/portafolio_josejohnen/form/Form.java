package com.portafoliojj.portafolio_josejohnen.form;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

public record Form (
        @Id
        Integer id,
        @NotEmpty
        String nombre,
        LocalDateTime fecha_nacimiento,
        @Positive
        Integer edad
){
        public Form {

        }
}
