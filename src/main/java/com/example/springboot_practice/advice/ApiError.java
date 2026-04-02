package com.example.springboot_practice.advice;

import lombok.Builder;
import lombok.Data;
import java.util.List;
import org.springframework.http.HttpStatus;

@Data
@Builder
public class ApiError {
    private HttpStatus status;
    private  String message;
    List<String> subErrors;
}
