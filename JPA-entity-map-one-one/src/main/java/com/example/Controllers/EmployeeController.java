package com.example.Controllers;



import com.example.*;
import com.example.Entity.Employee;
import com.example.repository.EmployeeRepository;
import com.example.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeRepository empRepository;

    @PostMapping("/saveEmployee")
    public ResponseEntity<String> saveEmployee(@RequestBody Employee empData) {
        empRepository.save(empData);
        return ResponseEntity.ok("Employee & Address saved");
    }

    @GetMapping("/getEmployees")
    public List<Employee> getEmployees() {
        return empRepository.findAll();
    }
}
