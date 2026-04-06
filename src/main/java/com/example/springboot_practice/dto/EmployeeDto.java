package com.example.springboot_practice.dto;

import com.example.springboot_practice.annotations.EmployeeRoleValidation;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
    private Long id;
//    @NotEmpty(message = "Name of the Employee cannot be empty")
    @NotBlank(message = "Name of the Employee cannot be blank")
    @Size(min = 3, max = 10, message = "NUmber of character in name should be in the range :[3,10]")
    private String name;

    @Email(message = "Email should be a valid email")
    private String email;

    @NotNull
    @Max(value = 60, message = "Age can not be more than 60")
    @Min(value = 18, message = "Age can not be less than 18")
    private Integer age;

    @NotBlank(message = "Role of the Employee cannot be blank")
//    @Pattern(regexp = "^(ADMIN|USER)$")
    @EmployeeRoleValidation  //Custom validation
    private String role; //ADMIN,USER

    @NotNull(message = "Salary of Employee should be not null")
    @Positive(message = "Salary of Employee should be positive")
    @Digits(integer = 6, fraction = 2, message = "Salary can be in the form XXXX.YY")
    private Double salary;

    @PastOrPresent(message = "Date of joining field in Employee can not be in Future")
    private LocalDate dateOfJoining;

    @AssertTrue(message = "Employee should be active")
    private Boolean isActive;

}
