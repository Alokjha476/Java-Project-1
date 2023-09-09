package com.employee.management.system.employeemanagement.repository;

import com.employee.management.system.employeemanagement.entities.Employee;
import com.employee.management.system.employeemanagement.entities.Identity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface IdentityRepository extends JpaRepository<Identity, Integer> {
    public void deleteByEmployee(Employee employee);
    List<Identity> findByEmployee(Employee employee);

}
