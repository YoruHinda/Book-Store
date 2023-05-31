package com.github.yoruhinda.BookStore.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "student")
@Getter
@Setter
@NoArgsConstructor
public class StudentModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long student_id;
    @Column(name = "student_name", nullable = false)
    private String student_name;
    @Column(name = "book", nullable = false)
    private String book;
    @Column(name = "devolution_date", nullable = false)
    private LocalDate devolution_date;
    @Column(name = "loan_date", nullable = false)
    private LocalDate loan_date;
    @Column(name = "devolution", nullable = true, columnDefinition = "TINYINT", length = 1)
    private boolean devolution;
}
