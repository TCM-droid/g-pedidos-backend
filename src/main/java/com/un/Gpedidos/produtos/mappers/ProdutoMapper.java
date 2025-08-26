package com.un.Gpedidos.produtos.mappers;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.un.Gpedidos.produtos.dto.ProdutoDto;
import com.un.Gpedidos.produtos.entity.ProdutoEntity;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface ProdutoMapper {
	
	static ProdutoMapper INSTANCE = Mappers.getMapper(ProdutoMapper.class);
	
	ProdutoEntity dtoToEntity(ProdutoDto produtoDto);
	ProdutoDto entityToDto(ProdutoEntity produtoEntity);
}
