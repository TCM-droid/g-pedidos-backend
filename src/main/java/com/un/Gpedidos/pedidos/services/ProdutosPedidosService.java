package com.un.Gpedidos.pedidos.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.un.Gpedidos.pedidos.entity.PedidoEntity;
import com.un.Gpedidos.pedidos.entity.ProdutoPedidoEntity;
import com.un.Gpedidos.pedidos.repository.ProdutosPedidosRepository;

@Service
public class ProdutosPedidosService {

	ProdutosPedidosRepository produtosPedidosRepository;
	
	public ProdutosPedidosService(ProdutosPedidosRepository produtosPedidosRepository) {
		this.produtosPedidosRepository = produtosPedidosRepository;
	}

	public void saveAll(List<ProdutoPedidoEntity> novosProdutosPedidos) {
		produtosPedidosRepository.saveAll(novosProdutosPedidos);
	}
	
	public List<ProdutoPedidoEntity> findAllByPedido(PedidoEntity pedido){
		return produtosPedidosRepository.findByPedido(pedido);
	}
}
