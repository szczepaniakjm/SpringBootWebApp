package com.app.controllers;

import com.app.exceptions.MyException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(MyException.class)
    public String myExceptionHandler(MyException e, Model model) {
        log.error(e.getExceptionInfo().getExceptionDateTime().toString());
        log.error(e.getExceptionInfo().getExceptionMessage());
        model.addAttribute("exceptionMessage", e.getExceptionInfo().getExceptionMessage());
        return "exceptions/exceptionPage";
    }

}
