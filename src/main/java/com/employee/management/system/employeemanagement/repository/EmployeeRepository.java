package com.employee.management.system.employeemanagement.repository;

import com.employee.management.system.employeemanagement.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    int deleteByName(String name);
    @Query(value = "select e from Employee e where e.id =:id")
    Employee findByEmployeeId(Integer id);
}
