package com.un.Gpedidos.pedidos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.un.Gpedidos.pedidos.dto.PedidoDto;
import com.un.Gpedidos.pedidos.services.PedidosService;

@RestController
@RequestMapping("/api/pedidos")
public class PedidosController {

	@Autowired
	private PedidosService pedidosService;
	
	@PostMapping("/cadastrar")
	public ResponseEntity<Boolean> cadastroNovoPedido(@RequestBody PedidoDto pedido) {
		Boolean cadastrado = pedidosService.cadastrarPedido(pedido);
		return ResponseEntity.status(HttpStatus.OK).body(cadastrado);
	}
}
