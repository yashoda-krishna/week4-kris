package com.example;



import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeRepository employeeRepository;

    // Save employee
    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        Employee saved = employeeRepository.save(employee);
        return ResponseEntity.ok(saved);
    }

    // Get all employees
    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    // Get single employee by composite key
    @GetMapping("/{employeeId}/{deptId}")
    public ResponseEntity<Employee> getEmployee(@PathVariable int employeeId, @PathVariable int deptId) {
        Employee.EmployeeId id = new Employee.EmployeeId(employeeId, deptId);
        Optional<Employee> emp = employeeRepository.findById(id);
        return emp.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Delete employee
    @DeleteMapping("/{employeeId}/{deptId}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable int employeeId, @PathVariable int deptId) {
        Employee.EmployeeId id = new Employee.EmployeeId(employeeId, deptId);
        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
