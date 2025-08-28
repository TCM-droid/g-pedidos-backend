package com.un.Gpedidos.pedidos.mappers;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.un.Gpedidos.pedidos.dto.ProdutoPedidoDto;
import com.un.Gpedidos.pedidos.entity.ProdutoPedidoEntity;
import com.un.Gpedidos.produtos.mappers.ProdutoMapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR, uses = ProdutoMapper.class)
public interface ProdutoPedidoMapper {

	static ProdutoPedidoMapper INSTANCE = Mappers.getMapper(ProdutoPedidoMapper.class);
	
	ProdutoPedidoEntity dtoToEntity(ProdutoPedidoDto produtoPedidoDto);
	ProdutoPedidoDto entityToDto(ProdutoPedidoEntity produtoPedidoEntity);
}
