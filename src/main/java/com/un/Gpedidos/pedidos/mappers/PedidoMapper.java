package com.un.Gpedidos.pedidos.mappers;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.un.Gpedidos.pedidos.dto.PedidoDto;
import com.un.Gpedidos.pedidos.entity.PedidoEntity;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface PedidoMapper {

	static PedidoMapper INSTANCE = Mappers.getMapper(PedidoMapper.class);
	
	PedidoEntity dtoToEntity(PedidoDto pedidoDto);
	
	@Mapping(target = "produtos", ignore = true)
	PedidoDto entityToDto(PedidoEntity pedidoEntity);
}
