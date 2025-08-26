package com.un.Gpedidos.produtos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.un.Gpedidos.produtos.dto.ProdutoDto;
import com.un.Gpedidos.produtos.entity.ProdutoEntity;
import com.un.Gpedidos.produtos.services.ProdutosService;

@RestController
@RequestMapping("/api/produtos")
public class ProdutosController {

	@Autowired
	ProdutosService produtosService;
	
	@GetMapping("/hello")
    public String sayHello() {
        return "Hello, produtos!";
    }
	
	@PostMapping("/cadastrar")
	public ResponseEntity<ProdutoEntity> cadastroProduto(@RequestBody ProdutoDto produto) {
		ProdutoEntity output = produtosService.converteDtoESalvaBanco(produto);
		return ResponseEntity.status(HttpStatus.OK).body(output);
	}
}
