package com.un.Gpedidos.pedidos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.un.Gpedidos.pedidos.entity.PedidoEntity;

@Repository
public interface PedidosRepository extends JpaRepository<PedidoEntity, Long> {

}
