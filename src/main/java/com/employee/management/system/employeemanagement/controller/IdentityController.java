package com.employee.management.system.employeemanagement.controller;

import com.employee.management.system.employeemanagement.dto.IdentityDto;
import com.employee.management.system.employeemanagement.entities.Employee;
import com.employee.management.system.employeemanagement.entities.Identity;
import com.employee.management.system.employeemanagement.service.EmployeeService;
import com.employee.management.system.employeemanagement.service.IdentityService;
import jdk.nashorn.internal.ir.Optimistic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class IdentityController {
    @Autowired
    EmployeeService employeeService;
    @Autowired
    IdentityService identityService;

    @PostMapping("employee/{empId}/identity")
    public ResponseEntity<Object> addIdentity(IdentityDto identityDto, @PathVariable Integer empId) {
        Optional<Employee> employeeOps = employeeService.findById(empId);
        if (employeeOps.isPresent()) {
            Employee employee = employeeOps.get();
            Identity identity = identityService.addIdentity(identityDto, employee);
            return new ResponseEntity<>(identity, HttpStatus.OK);
        }
        return new ResponseEntity<>("Employee Not Present", HttpStatus.BAD_REQUEST);
    }

    @PutMapping("identity/{id}")
    public ResponseEntity<Object> updateIdentity(@RequestBody IdentityDto identityDto, @PathVariable Integer id) {
        Identity identity = identityService.updateIdentity(identityDto, id);
        return new ResponseEntity<>(identity, HttpStatus.OK);

    }
    @DeleteMapping("identity/{id}")
    public ResponseEntity<Object> deleteIdentity(@PathVariable Integer id){
        identityService.deleteIdentity(id);
        return new ResponseEntity<>("Identity Deleted",HttpStatus.OK);
    }

}
