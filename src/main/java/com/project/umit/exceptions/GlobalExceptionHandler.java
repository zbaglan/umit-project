package com.project.umit.exceptions;

import com.project.umit.dto.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@RequiredArgsConstructor
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public Response exceptionHandler(Exception ex) {
        return Response.error(ex.getMessage());
    }
}
