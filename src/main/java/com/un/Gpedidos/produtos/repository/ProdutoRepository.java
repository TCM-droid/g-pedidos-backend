package com.un.Gpedidos.produtos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.un.Gpedidos.pedidos.entity.ProdutoPedidoEntity;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoPedidoEntity, Long> {

}
