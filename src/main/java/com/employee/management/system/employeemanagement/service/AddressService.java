package com.employee.management.system.employeemanagement.service;

import com.employee.management.system.employeemanagement.dto.AddressDto;
import com.employee.management.system.employeemanagement.entities.Address;
import com.employee.management.system.employeemanagement.entities.Employee;
import com.employee.management.system.employeemanagement.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {
    @Autowired
    private AddressRepository addressRepository;

    public Address addAddress(AddressDto addressDto, Employee employee) {
        if (employee != null) {
            Address address = new Address();
            address.setAddressLine1(addressDto.getAddressLine1());
            address.setAddressLine2(addressDto.getAddressLine2());
            address.setAddressLine3(addressDto.getAddressLine3());
            address.setCity(addressDto.getCity());
            address.setState(addressDto.getState());
            address.setPinCode(addressDto.getPinCode());
            address.setEmployee(employee);
            address.setAddressType(addressDto.getAddressType());
            return addressRepository.save(address);
        }
        return null;
    }

    public Address updateAddress( AddressDto addressDto, Integer id) {
      Optional<Address> addressOps =  addressRepository.findById(id);
      if (addressOps.isPresent()){
          Address address = addressOps.get();
          address.setAddressLine1(addressDto.getAddressLine1());
          address.setAddressLine2(addressDto.getAddressLine2());
          address.setAddressLine3(addressDto.getAddressLine3());
          address.setCity(addressDto.getCity());
          address.setState(addressDto.getState());
          address.setPinCode(addressDto.getPinCode());
          address.setAddressType(addressDto.getAddressType());
        return addressRepository.save(address);
      }
      return null;
    }
    @Transactional
    public void deleteAddress(Integer id){
        addressRepository.deleteById(id);

    }
    public Address getAddress(Integer id){
        return addressRepository.findById(id).orElse(null);

    }

    public void deleteByEmployee(Employee employee) {
        addressRepository.deleteByEmployee(employee);
    }

    public List<AddressDto> findByEmployee(Employee employee) {
        return addressRepository.findByEmployee(employee);
    }
}
