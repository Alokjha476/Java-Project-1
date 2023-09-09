package com.employee.management.system.employeemanagement.dto;

import lombok.Data;
@Data
public class IdentityDto {
    private Integer id;
    private String documentType;
    private String documentNumber;
    private String additionalDetail;
}
