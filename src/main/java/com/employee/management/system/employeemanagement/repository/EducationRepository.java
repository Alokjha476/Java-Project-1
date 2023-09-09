package com.employee.management.system.employeemanagement.repository;

import com.employee.management.system.employeemanagement.entities.Education;
import com.employee.management.system.employeemanagement.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EducationRepository extends JpaRepository<Education , Integer> {
     void deleteByEmployee(Employee employee);
     List<Education> findByEmployee(Employee employee);


}
