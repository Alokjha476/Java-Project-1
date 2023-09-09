package com.employee.management.system.employeemanagement.repository;

import com.employee.management.system.employeemanagement.dto.AddressDto;
import com.employee.management.system.employeemanagement.entities.Address;
import com.employee.management.system.employeemanagement.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {
    List<Address> findByPinCode(String pinCode);
    void deleteByEmployee(Employee employee);
    @Query(value = "select new com.employee.management.system.employeemanagement.dto.AddressDto(a.id, a.addressLine1, a.addressLine2, a.addressLine3, a.city, a.state, a.pinCode, a.addressType) from Address a where a.employee =:employee")
    List<AddressDto> findByEmployee(Employee employee);

}
