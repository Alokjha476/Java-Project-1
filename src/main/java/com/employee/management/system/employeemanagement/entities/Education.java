package com.employee.management.system.employeemanagement.entities;

import javax.persistence.*;
import lombok.Data;

@Data
@Entity
public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer year;
    private String degree;
    private String institute;
    @ManyToOne

    private Employee employee;
}
