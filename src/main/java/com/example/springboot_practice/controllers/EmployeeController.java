package com.example.springboot_practice.controllers;

import com.example.springboot_practice.dto.EmployeeDto;
import com.example.springboot_practice.entities.EmployeeEntity;
import com.example.springboot_practice.repositories.EmployeeRepository;
import com.example.springboot_practice.services.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


//    @GetMapping(path = "/secretMessage")
//    public String getMySupperSecretMessage(){
//        return "Message is secret";
//    }

    @GetMapping(path = "/{employeeId}")
    public EmployeeEntity getEmployeeById(@PathVariable(name = "employeeId") Long id){
//        return new EmployeeDto(id,"Sweta", "Sweta@gmail.com",
//                24, LocalDate.of(2026,01,02),true );
        return employeeService.getEmployeeById(id);
    }

    @GetMapping
    public List<EmployeeEntity> getAllEmployees(@RequestParam(required = false, name = "InputAge") Integer age){
//        return "Hi age " +age;
       return employeeService.getAllEmployees();
    }

//    @PostMapping
//    public String createNewEmployee(){
//        return "Hello from post";
//    }
    @PostMapping
    public EmployeeEntity createNewEmployee(@RequestBody EmployeeEntity inputEmployee){
//        inputEmployee.setId(100L);
//        inputEmployee.setDateOfJoining(LocalDate.of(2026,03,01));
//        return inputEmployee;
        return employeeService.createNewEmployee(inputEmployee);
    }

}
