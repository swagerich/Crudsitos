package com.erich.codeando.handler;

import com.erich.codeando.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class HandlerException {

    @ExceptionHandler(NotFoundException.class)
    public ProblemDetail NotFoundExceptionHandler(NotFoundException e) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, e.getMessage());
        problemDetail.setTitle("NOT FOUND");
        problemDetail.setDetail("");
        problemDetail.setProperty("hora: ", LocalDateTime.now());
        return problemDetail;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ProblemDetail InvalidExceptionHandler(MethodArgumentNotValidException e) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, e.getMessage());
        Map<String, Object> response = new HashMap<>();
        List<String> list = e.getBindingResult().getFieldErrors()
                .stream().map(err -> "El campo" + " " + err.getDefaultMessage())
                .toList();
        response.put("Upps", list);
        problemDetail.setType(URI.create("https://notfound.org/es"));
        problemDetail.setTitle("Bad Request");
        problemDetail.setDetail("");
        problemDetail.setProperty("Hora: ", LocalDateTime.now());
        problemDetail.setProperty("Invalidate!", response);
        return problemDetail;
    }
}
