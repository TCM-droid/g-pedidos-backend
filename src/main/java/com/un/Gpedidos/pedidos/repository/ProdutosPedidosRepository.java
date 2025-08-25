package com.un.Gpedidos.pedidos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.un.Gpedidos.pedidos.entity.ProdutoPedidoEntity;

public interface ProdutosPedidosRepository extends JpaRepository<ProdutoPedidoEntity, Long> {

}
