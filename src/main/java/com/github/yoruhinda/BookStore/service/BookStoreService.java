package com.github.yoruhinda.BookStore.service;

import com.github.yoruhinda.BookStore.model.StudentModel;
import com.github.yoruhinda.BookStore.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookStoreService {
    @Autowired
    private StudentRepository studentRepository;

    public StudentModel findById(Long id){
        return studentRepository.findById(id).orElse(null);
    }

    public List<StudentModel> findAll(){
        return studentRepository.findAll();
    }

    public StudentModel save(StudentModel studentModel) {
        return studentRepository.save(studentModel);
    }

    public void delete(Long id){
        studentRepository.deleteById(id);
    }
}
