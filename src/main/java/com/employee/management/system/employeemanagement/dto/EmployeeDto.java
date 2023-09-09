package com.employee.management.system.employeemanagement.dto;

import lombok.Data;

import java.util.List;

@Data
public class EmployeeDto {
    private Integer id;
    private  String name;
    private String salary;
    private String phone;
    private String email;
    private String designation;
    private List<AddressDto> address;
    private List<EducationDto> educations;
    private List<IdentityDto> identities;
}
