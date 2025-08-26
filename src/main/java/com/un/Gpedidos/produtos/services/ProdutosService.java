package com.un.Gpedidos.produtos.services;

import org.springframework.stereotype.Service;

import com.un.Gpedidos.produtos.dto.ProdutoDto;
import com.un.Gpedidos.produtos.entity.ProdutoEntity;
import com.un.Gpedidos.produtos.mappers.ProdutoMapper;
import com.un.Gpedidos.produtos.repository.ProdutoRepository;

@Service
public class ProdutosService {
	
	ProdutoMapper mapper;
	
	ProdutoRepository produtoRepository;
	
	public ProdutosService(ProdutoRepository produtoRepository, ProdutoMapper mapper) {
		this.mapper = mapper;
		this.produtoRepository = produtoRepository;
	}
	
	
	
	public ProdutoEntity converteDtoESalvaBanco(ProdutoDto dto) {
		return mapper.dtoToEntity(dto);
	}
}
