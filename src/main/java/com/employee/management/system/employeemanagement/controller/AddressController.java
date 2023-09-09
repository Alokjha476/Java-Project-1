package com.employee.management.system.employeemanagement.controller;

import com.employee.management.system.employeemanagement.dto.AddressDto;
import com.employee.management.system.employeemanagement.entities.Address;
import com.employee.management.system.employeemanagement.entities.Employee;
import com.employee.management.system.employeemanagement.service.AddressService;
import com.employee.management.system.employeemanagement.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class AddressController {
    @Autowired
    public AddressService addressService;
    @Autowired
    private EmployeeService employeeService;
    @PostMapping("/employee/{empId}/address") // for add
    public ResponseEntity<Object> addAddress(@RequestBody AddressDto addressDto, @PathVariable Integer empId) {
        Optional<Employee> employeeOps = employeeService.findById(empId);
        if (employeeOps.isPresent()) {
            Employee employee = employeeOps.get();
            Address address = addressService.addAddress(addressDto, employee);
            return new ResponseEntity<>(address, HttpStatus.OK);
        }
        return new ResponseEntity<>("Employee Not Present", HttpStatus.BAD_REQUEST);
    }
    @PutMapping("address/{id}")
    public ResponseEntity<Object> updateAddress(@RequestBody AddressDto addressDto, @PathVariable Integer id){
        Address address = addressService.updateAddress(addressDto,id);
        return new ResponseEntity<>(address, HttpStatus.OK);
    }
    @DeleteMapping("address/{id}")
    public ResponseEntity<Object> deleteAddress(@PathVariable Integer id){
        addressService.deleteAddress(id);
        return new ResponseEntity<>("Adress deleted", HttpStatus.OK);
    }
    @GetMapping("address/{id}")
    public ResponseEntity<Object> getAddress(@PathVariable Integer id){
      Address address =  addressService.getAddress(id);
        return new ResponseEntity<>(address, HttpStatus.OK);



    }


}
