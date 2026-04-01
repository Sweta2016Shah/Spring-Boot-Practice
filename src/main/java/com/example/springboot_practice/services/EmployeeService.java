package com.example.springboot_practice.services;

import com.example.springboot_practice.dto.EmployeeDto;
import com.example.springboot_practice.entities.EmployeeEntity;
import com.example.springboot_practice.repositories.EmployeeRepository;
import org.apache.el.util.ReflectionUtil;
import org.modelmapper.ModelMapper;
import org.springframework.util.ReflectionUtils;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    public EmployeeDto getEmployeeById(Long id) {
        EmployeeEntity employeeEntity = employeeRepository.findById(id).orElse(null);
        return modelMapper.map(employeeEntity, EmployeeDto.class);
    }

    public List<EmployeeDto> getAllEmployees() {
        List<EmployeeEntity> employeeEntities = employeeRepository.findAll();
         return employeeEntities
                 .stream()
                 .map(employeeEntity -> modelMapper.map(employeeEntity, EmployeeDto.class))
                 .toList();
    }

    public EmployeeDto createNewEmployee(EmployeeDto inputEmployee) {
        EmployeeEntity toSaveEntity = modelMapper.map(inputEmployee, EmployeeEntity.class);
        EmployeeEntity employeeEntity = employeeRepository.save(toSaveEntity);
        return modelMapper.map(employeeEntity, EmployeeDto.class);
    }

    public EmployeeDto updatedEmployeeById(Long employeeId, EmployeeDto employeeDto) {
        EmployeeEntity employeeEntity = modelMapper.map(employeeDto, EmployeeEntity.class);
        employeeEntity.setId(employeeId);
        EmployeeEntity saveEmployeeEntity = employeeRepository.save(employeeEntity);
        return modelMapper.map(saveEmployeeEntity, EmployeeDto.class);
    }
    public boolean isExistsyEmployeeId(Long id){
        return employeeRepository.existsById(id);
    }

    public boolean deleteEmployeeById(Long employeeId) {
        boolean exist = isExistsyEmployeeId(employeeId);
        if(!exist) return false;
        employeeRepository.deleteById(employeeId);
        return true;
    }

    public EmployeeDto updatePartialEmployeeById(Long employeeId, Map<String, Object> updates) {
        if(!isExistsyEmployeeId(employeeId)) return null;
        EmployeeEntity employeeEntity = employeeRepository.findById(employeeId).get();
        updates.forEach((field,value)->{
            Field feildToBeUpdated = ReflectionUtils.findField(EmployeeEntity.class,field);
            feildToBeUpdated.setAccessible(true);
            ReflectionUtils.setField(feildToBeUpdated,employeeEntity,value);
        });
        return modelMapper.map(employeeRepository.save(employeeEntity),EmployeeDto.class);

    }
}
