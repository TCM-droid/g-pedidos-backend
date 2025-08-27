package com.un.Gpedidos.produtos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.un.Gpedidos.produtos.dto.ProdutoDto;
import com.un.Gpedidos.produtos.services.ProdutosService;

@RestController
@RequestMapping("/api/produtos")
public class ProdutosController {

	@Autowired
	ProdutosService produtosService;
	
	@GetMapping("/")
    public ResponseEntity<List<ProdutoDto>> buscaTodos() {
		List<ProdutoDto> produtos = produtosService.findAllNotDeleted();
        return ResponseEntity.status(HttpStatus.OK).body(produtos);
    }
	
	@GetMapping("/{id}")
    public ResponseEntity<ProdutoDto> buscaProduto(@PathVariable("id") Long idProduto) {
		ProdutoDto output = produtosService.buscaProduto(idProduto);
        return ResponseEntity.status(HttpStatus.OK).body(output);
    }
	
	@PostMapping("/")
	public ResponseEntity<ProdutoDto> atualizaOuCadastraProduto(@RequestBody ProdutoDto produto) {
		ProdutoDto output = produtosService.atualizaOuCadastraProduto(produto);
		return ResponseEntity.status(HttpStatus.OK).body(output);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> excluiProduto(@PathVariable("id") Long idProduto) {
		Boolean deleted = produtosService.softDeleteProduto(idProduto);
		return ResponseEntity.status(HttpStatus.OK).body(deleted);
	} 
}
