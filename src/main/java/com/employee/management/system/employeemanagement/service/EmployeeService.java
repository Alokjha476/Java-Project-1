package com.employee.management.system.employeemanagement.service;


import com.employee.management.system.employeemanagement.dto.AddressDto;
import com.employee.management.system.employeemanagement.dto.EducationDto;
import com.employee.management.system.employeemanagement.dto.EmployeeDto;
import com.employee.management.system.employeemanagement.dto.IdentityDto;
import com.employee.management.system.employeemanagement.entities.Employee;
import com.employee.management.system.employeemanagement.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private AddressService addressService;
    @Autowired
    private IdentityService identityService;
    @Autowired
    private EducationService educationService;


    public Employee addEmployee(EmployeeDto employeeDto) {
        Employee employee = new Employee();
        employee.setName(employeeDto.getName());
        employee.setPhone(employeeDto.getPhone());
        employee.setEmail(employeeDto.getEmail());
        employee.setSalary(employeeDto.getSalary());
        employee.setDesignation(employeeDto.getDesignation());
        employee = employeeRepository.save(employee);
        if (employeeDto.getAddress() != null && !employeeDto.getAddress().isEmpty()) {
            for (AddressDto add : employeeDto.getAddress()) {
                addressService.addAddress(add, employee);
            }
        }
        if (employeeDto.getEducations() != null && !employeeDto.getEducations().isEmpty()){
            for (EducationDto edu: employeeDto.getEducations()) {
                educationService.addEducation(edu, employee);
            }
        }
      if (employeeDto.getIdentities() != null && !employeeDto.getIdentities().isEmpty()){
          for (IdentityDto id: employeeDto.getIdentities()) {
              identityService.addIdentity(id,employee);
          }
      }

        return employee;
    }
    // create data in database

    public Employee updateEmployee(EmployeeDto employeeDto) {
        Optional<Employee> response = findById(employeeDto.getId());
        if (response.isPresent()) {
            Employee employee = response.get();
            if (employeeDto.getName() != null && !employeeDto.getName().isEmpty()) {
                employee.setName(employeeDto.getName());
            }
            if (employeeDto.getPhone() != null && !employeeDto.getPhone().isEmpty()) {
                employee.setPhone(employeeDto.getPhone());
            }
            if (employeeDto.getEmail() != null && !employeeDto.getEmail().isEmpty()) {
                employee.setEmail(employeeDto.getEmail());
            }
            if (employeeDto.getSalary() != null && !employeeDto.getSalary().isEmpty()) {
                employee.setSalary(employeeDto.getSalary());
            }
            if (employeeDto.getDesignation() != null && !employeeDto.getDesignation().isEmpty()) {
                employee.setDesignation(employeeDto.getDesignation());
            }
            return employeeRepository.save(employee);
        }
        return null;
    }


    @Transactional
    public void deleteEmployee(Integer id) {
        addressService.deleteByEmployee(new Employee(id));
        educationService.deleteByEmployee(new Employee(id));
        identityService.deleteByEmployee(new Employee(id));
        employeeRepository.deleteById(id);
    }

    public Map<String, Object> findEmployee(Integer id) {
            Employee employee = employeeRepository.findByEmployeeId(id);
            if (employee != null) {
                // or can write as {return response.map(Collections::singletonList).orElse(null);}
                Map<String, Object> objectMap = new LinkedHashMap<>();
                objectMap.put("employee", employee);
                objectMap.put("address", addressService.findByEmployee(employee));
                objectMap.put("education", educationService.findByEmployee(employee));
                objectMap.put("identity", identityService.findByEmployee(employee));
                return objectMap;
            }
        return null;
    }

    public List<Employee> findAllEmployee() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> findById(Integer id) {
        return employeeRepository.findById(id);
    }

}



