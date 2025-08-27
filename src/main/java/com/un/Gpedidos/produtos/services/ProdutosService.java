package com.un.Gpedidos.produtos.services;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

import com.un.Gpedidos.exceptions.GpedidosException;
import com.un.Gpedidos.exceptions.GpedidosNotFoundException;
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
	
	public ProdutoDto atualizaOuCadastraProduto(ProdutoDto dto) {
		
		validateDto(dto);
		
		ProdutoEntity entity = mapper.dtoToEntity(dto);
		
		if(Strings.isEmpty(entity.getSku())) {
			entity.setSku(UUID.randomUUID().toString().split("-")[0]);
		}
		
		produtoRepository.save(entity);
		
		return mapper.entityToDto(entity);
	}

	private void validateDto(ProdutoDto dto) {
		if(Strings.isEmpty(dto.getNome())) throw new GpedidosException("Informe o nome do produto");

		if(Strings.isEmpty(dto.getMoeda())) throw new GpedidosException("Informe a moeda do produto");

		if(dto.getPreco() == null) throw new GpedidosException("Informe o preço do produto");
	}

	public ProdutoDto buscaProduto(Long idProduto) {
		
		ProdutoEntity produto = buscaProdutoEntity(idProduto);

		return mapper.entityToDto(produto); 
	}

	private ProdutoEntity buscaProdutoEntity(Long idProduto) {
		Optional<ProdutoEntity> produtoOpt = produtoRepository.findById(idProduto);
		
		ProdutoEntity produto = produtoOpt.orElseThrow( () -> new GpedidosNotFoundException("Produto não encontrado"));
		return produto;
	}

	public Boolean softDeleteProduto(Long idProduto) {
		
		ProdutoEntity produto = buscaProdutoEntity(idProduto);
		produto.setDeleted(true);
		produtoRepository.save(produto);
		
		return true;
	}

	public List<ProdutoDto> findAllNotDeleted() {
		return produtoRepository.findByDeletedFalse().stream().map(mapper::entityToDto).collect(Collectors.toList());
	}
}
