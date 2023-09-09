package com.employee.management.system.employeemanagement.service;

import com.employee.management.system.employeemanagement.dto.IdentityDto;
import com.employee.management.system.employeemanagement.entities.Employee;
import com.employee.management.system.employeemanagement.entities.Identity;
import com.employee.management.system.employeemanagement.repository.IdentityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class IdentityService {
    @Autowired
    private IdentityRepository identityRepository;

    public void deleteByEmployee(Employee employee) {
        identityRepository.deleteByEmployee(employee);
    }

    public List<Identity> findByEmployee(Employee employee) {
        return identityRepository.findByEmployee(employee);

    }

    public Identity addIdentity(IdentityDto identityDto, Employee employee) {
        Identity identity = new Identity();
        identity.setEmployee(employee);
        identity.setAdditionalDetail(identityDto.getAdditionalDetail());
        identity.setDocumentNumber(identityDto.getDocumentNumber());
        identity.setDocumentType(identityDto.getDocumentType());
        return identityRepository.save(identity);

    }

    public Identity updateIdentity(IdentityDto identityDto, Integer id) {
        Optional<Identity> identity = identityRepository.findById(id);
        if (identity.isPresent()) {
            Identity obj = identity.get();
            obj.setDocumentType(identityDto.getDocumentType());
            obj.setDocumentNumber(identityDto.getDocumentNumber());
            obj.setAdditionalDetail(identityDto.getAdditionalDetail());
            return identityRepository.save(obj);
        }
        return null;
    }
    @Transactional
    public void deleteIdentity(Integer id){
         identityRepository.deleteById(id);

    }


}
