package com.un.Gpedidos.pedidos.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pedidos")
public class PedidosController {

	
	@GetMapping("/hello")
    public String sayHello() {
        return "Hello, pedidos!";
    }
}
