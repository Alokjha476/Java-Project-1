package com.employee.management.system.employeemanagement.controller;

import com.employee.management.system.employeemanagement.dto.EmployeeDto;
import com.employee.management.system.employeemanagement.entities.Employee;
import com.employee.management.system.employeemanagement.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class EmployeeController {
    @Autowired
    public EmployeeService employeeService;

    @PostMapping("/employee") // for add
    public ResponseEntity<Object> addEmployee(@RequestBody EmployeeDto employeeDto) {
        Employee employee = employeeService.addEmployee(employeeDto);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PutMapping("/employee") // for update
    public ResponseEntity<Object> updateEmployee(@RequestBody EmployeeDto employeeDto) {
        Employee employee = employeeService.updateEmployee(employeeDto);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }
    @DeleteMapping("/employee/{id}") // for delete
    public ResponseEntity<Object> updateEmployee(@PathVariable Integer id) {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>("Employee deleted", HttpStatus.OK);
    }
    @GetMapping("/employee") // for get
    public ResponseEntity<Object> findEmployee(@RequestParam Integer id){
        Map<String, Object> employees = employeeService.findEmployee(id);
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/employee/all") // for get all employee
    public ResponseEntity<Object> findAllEmployee(){
        List<Employee> employees = employeeService.findAllEmployee();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }


}
