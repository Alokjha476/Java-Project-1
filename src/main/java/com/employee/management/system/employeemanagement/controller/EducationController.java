package com.employee.management.system.employeemanagement.controller;

import com.employee.management.system.employeemanagement.dto.EducationDto;
import com.employee.management.system.employeemanagement.entities.Education;
import com.employee.management.system.employeemanagement.entities.Employee;
import com.employee.management.system.employeemanagement.service.EducationService;
import com.employee.management.system.employeemanagement.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class EducationController {
    @Autowired
    private EducationService educationService;
    @Autowired
    EmployeeService employeeService;


    @PostMapping("/employee/{empId}/education") // for add
    public ResponseEntity<Object> addEducation(@RequestBody EducationDto educationDto, @PathVariable Integer empId) {
        Optional<Employee> employeeOps = employeeService.findById(empId);
        if (employeeOps.isPresent()) {
            Employee employee = employeeOps.get();
            Education education = educationService.addEducation(educationDto, employee);
            return new ResponseEntity<>(education, HttpStatus.OK);
        }
        return new ResponseEntity<>("Employee Not Present", HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/education/{eduId}")
    public ResponseEntity<Object> deleteEducation(@PathVariable("eduId") Integer id) {
        educationService.deleteEducation(id);
        return new ResponseEntity<>("Education deleted", HttpStatus.OK);
    }

    @PutMapping("/education/{eduId}")
    public ResponseEntity<Object> updateEducation(@RequestBody EducationDto educationDto, @PathVariable Integer eduId) {
        educationService.updateEducation(educationDto, eduId);
        return new ResponseEntity<>("Education updated", HttpStatus.OK);
    }
}
