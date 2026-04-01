package com.example.springboot_practice.controllers;

import com.example.springboot_practice.dto.EmployeeDto;
import com.example.springboot_practice.services.EmployeeService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/{employeeId}")
    public EmployeeDto getEmployeeById(@PathVariable(name = "employeeId") Long id){
        return employeeService.getEmployeeById(id);
    }

    @GetMapping
    public List<EmployeeDto> getAllEmployees(@RequestParam(required = false, name = "InputAge") Integer age){
       return employeeService.getAllEmployees();
    }

    @PostMapping
    public EmployeeDto createNewEmployee(@RequestBody EmployeeDto inputEmployee){
        return employeeService.createNewEmployee(inputEmployee);
    }

    @PutMapping(path = "/{employeeId}")
    public EmployeeDto updatedEmployeeById(@RequestBody EmployeeDto employeeDto, @PathVariable Long employeeId){
        return employeeService.updatedEmployeeById(employeeId, employeeDto);
    }
    @DeleteMapping(path = "/{employeeId}")
    public boolean deleteEmployeeById(@PathVariable Long employeeId){
       return employeeService.deleteEmployeeById(employeeId);
    }

    @PatchMapping(path = "/{employeeId}")
    public EmployeeDto updatePartialEmployeeById(@RequestBody Map<String, Object> updates, @PathVariable Long employeeId){
        return employeeService.updatePartialEmployeeById(employeeId, updates);
    }



}
