package com.un.Gpedidos.pedidos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.un.Gpedidos.pedidos.entity.PedidoEntity;
import com.un.Gpedidos.pedidos.entity.ProdutoPedidoEntity;
import com.un.Gpedidos.produtos.entity.ProdutoEntity;

public interface ProdutosPedidosRepository extends JpaRepository<ProdutoPedidoEntity, Long> {
	
	public List<ProdutoPedidoEntity> findByPedido(PedidoEntity pedido);
	
	public List<ProdutoPedidoEntity> findByProduto(ProdutoEntity produto);
}
