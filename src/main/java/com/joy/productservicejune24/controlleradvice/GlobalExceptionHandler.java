package com.joy.productservicejune24.controlleradvice;

import com.joy.productservicejune24.dtos.ExceptionDto;
import com.joy.productservicejune24.exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<ExceptionDto> handleArithmeticException() {
        ExceptionDto exceptionDto = new ExceptionDto();
        exceptionDto.setMessage("Arithmetic exception has happened");
        exceptionDto.setSolution("I don't know, please try again");

        ResponseEntity<ExceptionDto> response = new ResponseEntity<>(
                exceptionDto,
                HttpStatus.BAD_REQUEST
        );

        return response;
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<String> handleNullPointerException() {
        ResponseEntity<String> response = new ResponseEntity<>(
                "Something went wrong, Inside the Controller Advice",
                HttpStatus.NOT_FOUND
        );

        return response;
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ExceptionDto> handleProductNotFoundException(){
        ExceptionDto exceptionDto = new ExceptionDto();
        exceptionDto.setMessage("Product not found.");
        exceptionDto.setSolution("Please try again with a valid Product ID");

        ResponseEntity<ExceptionDto> response = new ResponseEntity<>(
                exceptionDto,
                HttpStatus.BAD_REQUEST
        );

        return response;
    }
}
