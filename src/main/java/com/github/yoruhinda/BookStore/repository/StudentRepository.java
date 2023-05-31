package com.github.yoruhinda.BookStore.repository;

import com.github.yoruhinda.BookStore.model.StudentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<StudentModel, Long> {
}
