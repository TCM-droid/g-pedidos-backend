package com.un.Gpedidos.relatorios.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/relatorios")
public class RelatoriosController {

	@GetMapping("/hello")
    public String sayHello() {
        return "Hello, relatorios!";
    }
}
