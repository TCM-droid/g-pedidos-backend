package com.un.Gpedidos.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionControllerAdvice {

	@org.springframework.web.bind.annotation.ExceptionHandler(GpedidosException.class)
    public ResponseEntity<Map<String, String>> exceptionGenerica(GpedidosException ex) {
        Map<String, String> response = new HashMap<>();
        response.put("error", ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
	
	@org.springframework.web.bind.annotation.ExceptionHandler(GpedidosNotFoundException.class)
    public ResponseEntity<Map<String, String>> exceptionNotFound(GpedidosNotFoundException ex) {
        Map<String, String> response = new HashMap<>();
        response.put("error", ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
}
