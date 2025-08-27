package com.un.Gpedidos.produtos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.un.Gpedidos.produtos.entity.ProdutoEntity;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoEntity, Long> {

	public List<ProdutoEntity> findByDeletedFalse();
}
