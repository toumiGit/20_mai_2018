package de.wagawin.controller;

import de.wagawin.exception.ColorException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class ControllerExceptionHandler {

    @ExceptionHandler(ColorException.class)
    public ResponseEntity handleException(ColorException e) {
        return ResponseEntity
                .status(HttpStatus.FORBIDDEN)
                .body(e.getMessage());
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity handleException(NullPointerException e) {
        log.info(e.getMessage());
        return ResponseEntity
                .status(HttpStatus.FORBIDDEN)
                .body("not allowed");
    }
}
