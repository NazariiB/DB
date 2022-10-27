package com.example.laba5.controller;

import com.example.laba5.exception.ItemNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceprionHandlerController {
    @ResponseBody
    @ExceptionHandler(ItemNotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String itemNotFound(ItemNotFound ex) {
        return ex.getMessage();
    }
}
