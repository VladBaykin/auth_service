package com.baykin.auth_service.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.baykin.auth_service.model.Employee;
import com.baykin.auth_service.repository.EmployeeRepository;
import com.baykin.auth_service.repository.PersonRepository;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeRepository employeeRepository;
    private final PersonRepository personRepository;

    public EmployeeController(EmployeeRepository employeeRepository, PersonRepository personRepository) {
        this.employeeRepository = employeeRepository;
        this.personRepository = personRepository;
    }

    @GetMapping("/")
    public List<Employee> findAll() {
        return (List<Employee>) this.employeeRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> findById(@PathVariable int id) {
        var employee = employeeRepository.findById(id);
        return new ResponseEntity<>(
                employee.orElse(new Employee()),
                employee.isPresent() ? HttpStatus.OK : HttpStatus.NOT_FOUND
        );
    }

    @PostMapping("/")
    public ResponseEntity<Employee> create(@RequestBody Employee employee) {
        employee.setHiringDate(LocalDateTime.now());
        return new ResponseEntity<>(
                this.employeeRepository.save(employee),
                HttpStatus.CREATED
        );
    }

    @PutMapping("/")
    public ResponseEntity<Void> update(@RequestBody Employee employee) {
        employee.setHiringDate(LocalDateTime.now());
        this.employeeRepository.save(employee);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        Employee employee = employeeRepository.findById(id).get();
        this.employeeRepository.delete(employee);
        return ResponseEntity.ok().build();
    }
}
