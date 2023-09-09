package com.employee.management.system.employeemanagement.entities;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
public class Identity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String documentType;
    private String documentNumber;
    private String additionalDetail;
    @CreationTimestamp
    private Timestamp createdDate;
    @ManyToOne
    private Employee employee;
}
