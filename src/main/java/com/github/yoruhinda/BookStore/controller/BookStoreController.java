package com.github.yoruhinda.BookStore.controller;

import com.github.yoruhinda.BookStore.dto.StudentDto;
import com.github.yoruhinda.BookStore.model.StudentModel;
import com.github.yoruhinda.BookStore.service.BookStoreService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/bookstore")
public class BookStoreController {
    @Autowired
    private BookStoreService bookStoreService;

    @GetMapping
    public ResponseEntity<List<StudentModel>> listAllStudents(){
        return new ResponseEntity<List<StudentModel>>(bookStoreService.findAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<StudentModel> findStudentById(@PathVariable Long id){
        return new ResponseEntity<StudentModel>(bookStoreService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<StudentModel> saveStudent(@RequestBody @Valid StudentDto studentDto){
        StudentModel studentModel = new StudentModel();
        BeanUtils.copyProperties(studentDto, studentModel);
        return new ResponseEntity<StudentModel>(bookStoreService.save(studentModel), HttpStatus.CREATED);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<StudentModel> updateStudent(@PathVariable Long id, @RequestBody @Valid StudentModel studentModel){
        StudentModel studentUpdated = bookStoreService.findById(id);
        studentUpdated.setStudent_name(studentModel.getStudent_name());
        studentUpdated.setBook(studentModel.getBook());
        studentUpdated.setDevolution(studentModel.isDevolution());
        studentUpdated.setLoan_date(studentModel.getLoan_date());
        studentUpdated.setDevolution_date(studentModel.getDevolution_date());
        return new ResponseEntity<StudentModel>(bookStoreService.save(studentModel), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteStudent(@PathVariable Long id){
        bookStoreService.delete(id);
    }
}
