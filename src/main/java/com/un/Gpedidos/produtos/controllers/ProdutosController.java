package com.un.Gpedidos.produtos.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/produtos")
public class ProdutosController {

	@GetMapping("/hello")
    public String sayHello() {
        return "Hello, produtos!";
    }
}
