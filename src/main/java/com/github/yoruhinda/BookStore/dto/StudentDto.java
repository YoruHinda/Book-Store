package com.github.yoruhinda.BookStore.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class StudentDto {
    @NotBlank
    private String student_name;
    @NotBlank
    private String book;
    @NotNull
    private LocalDate devolution_date;
    @NotNull
    private LocalDate loan_date;
    private Boolean devolution = false;
}
