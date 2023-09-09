package com.employee.management.system.employeemanagement.service;

import com.employee.management.system.employeemanagement.dto.EducationDto;
import com.employee.management.system.employeemanagement.entities.Education;
import com.employee.management.system.employeemanagement.entities.Employee;
import com.employee.management.system.employeemanagement.repository.EducationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EducationService {
    @Autowired
    private EducationRepository educationRepository;
    public void deleteByEmployee(Employee employee) {
        educationRepository.deleteByEmployee(employee);
    }
    public List<Education> findByEmployee(Employee employee){
       return educationRepository.findByEmployee(employee);

    }
    public Education addEducation(EducationDto educationDto, Employee employee){
        Education edu = new Education();
        edu.setDegree(educationDto.getDegree());
        edu.setYear(educationDto.getYear());
        edu.setInstitute(educationDto.getInstitute());
        edu.setEmployee(employee);
        return educationRepository.save(edu);
    }
    public Education updateEducation(EducationDto educationDto , Integer id){
       Optional<Education> edu = educationRepository.findById(id);
       if (edu.isPresent()){
         Education obj = edu.get();
         obj.setInstitute(educationDto.getInstitute());
         obj.setYear(educationDto.getYear());
         obj.setDegree(educationDto.getDegree());
         return educationRepository.save(obj);
       }
       return null;
    }
    @Transactional
    public void deleteEducation(Integer id){
        educationRepository.deleteById(id);
    }
}
