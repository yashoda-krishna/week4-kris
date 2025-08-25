package com.example.controller;


import com.example.dao.StudentDAO;
import com.example.model.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentDAO dao;

    public StudentController(StudentDAO dao) {
        this.dao = dao;
    }

    @PostMapping
    public ResponseEntity<String> add(@RequestBody Student student) {
        int rows = dao.insert(student);
        return ResponseEntity.ok(rows + " row(s) inserted");
    }

    @GetMapping
    public List<Student> all() {
        return dao.findAll();
    }

    @GetMapping("/search")
    public List<Student> byName(@RequestParam String name) {
        return dao.findByName(name);
    }

    @PutMapping("/course")
    public ResponseEntity<String> updateCourse(@RequestParam String name,
                                               @RequestParam int age,
                                               @RequestParam String oldCourse,
                                               @RequestParam String newCourse) {
        int rows = dao.updateCourse(name, age, oldCourse, newCourse);
        return ResponseEntity.ok(rows + " row(s) updated");
    }

    @DeleteMapping
    public ResponseEntity<String> delete(@RequestParam String name,
                                         @RequestParam int age,
                                         @RequestParam String course) {
        int rows = dao.delete(name, age, course);
        return ResponseEntity.ok(rows + " row(s) deleted");
    }
}
