package com.un.Gpedidos.pedidos.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

import com.un.Gpedidos.exceptions.GpedidosException;
import com.un.Gpedidos.pedidos.dto.PedidoDto;
import com.un.Gpedidos.pedidos.dto.ProdutoPedidoDto;
import com.un.Gpedidos.pedidos.entity.PedidoEntity;
import com.un.Gpedidos.pedidos.entity.ProdutoPedidoEntity;
import com.un.Gpedidos.pedidos.mappers.PedidoMapper;
import com.un.Gpedidos.pedidos.mappers.ProdutoPedidoMapper;
import com.un.Gpedidos.pedidos.repository.PedidosRepository;
import com.un.Gpedidos.pedidos.repository.ProdutosPedidosRepository;
import com.un.Gpedidos.produtos.entity.ProdutoEntity;
import com.un.Gpedidos.produtos.services.ProdutosService;

@Service
public class PedidosService {

	PedidosRepository pedidosRepository;
	ProdutosPedidosRepository produtosPedidosRepository;
	PedidoMapper pedidoMapper;
	ProdutoPedidoMapper produtoPedidoMapper;
	ProdutosService produtosService;
	
	public PedidosService(PedidosRepository pedidosRepository, ProdutosPedidosRepository produtosPedidosRepository, PedidoMapper pedidoMapper, ProdutoPedidoMapper produtoPedidoMapper, ProdutosService produtosService) {
		this.pedidosRepository = pedidosRepository;
		this.produtosPedidosRepository = produtosPedidosRepository;
		this.pedidoMapper = pedidoMapper;
		this.produtoPedidoMapper = produtoPedidoMapper;
		this.produtosService = produtosService;
	}
	
	public Boolean cadastrarPedido(PedidoDto pedido) {
		
		PedidoEntity novoPedido = validaPedido(pedido);
		
		List<ProdutoPedidoEntity> novosProdutosPedidos = calculaSubTotais(pedido.getProdutos());
		
		BigDecimal totalPedido = calculaTotalPedido(novosProdutosPedidos);
		
		salvar(novoPedido, novosProdutosPedidos, totalPedido);
		
		return true;
	}


	private PedidoEntity validaPedido(PedidoDto pedido) {
		if(CollectionUtils.isEmpty(pedido.getProdutos()))  throw new GpedidosException("É necessário escolher ao menos um produto em um pedido");
		
		pedido.getProdutos().forEach(prodP -> {
			
			if(prodP.getProduto() == null) throw new GpedidosException("Um dos produtos selecionado está sem informações");

			if(prodP.getProduto().getId() == null) throw new GpedidosException("Um dos produtos selecionado não foi cadastrado");

			if(prodP.getQuantidade() == null || prodP.getQuantidade() <= 0) throw new GpedidosException("Um dos produtos informado está com quantidade menor ou igual a zero");
		});
		
		return pedidoMapper.dtoToEntity(pedido);
	}

	private List<ProdutoPedidoEntity> calculaSubTotais(List<ProdutoPedidoDto> produtos) {
		List<ProdutoPedidoEntity> novasEntities = new ArrayList<>();
		
		for(ProdutoPedidoDto produtoPedido : produtos) {
			ProdutoPedidoEntity novoProdutoPedido = produtoPedidoMapper.dtoToEntity(produtoPedido);
			
			ProdutoEntity produtoEntity = produtosService.buscaProdutoEntity(produtoPedido.getProduto().getId());
			
			novoProdutoPedido.setProduto(produtoEntity);
			
			BigDecimal preco = produtoEntity.getPreco();
			
			novoProdutoPedido.setTotalProdutos(preco.multiply(BigDecimal.valueOf(novoProdutoPedido.getQuantidade())));
			
			novasEntities.add(novoProdutoPedido);
		}
		
		return novasEntities;
	}

	private BigDecimal calculaTotalPedido(List<ProdutoPedidoEntity> novosProdutosPedidos) {
		BigDecimal total = novosProdutosPedidos.stream().map(ProdutoPedidoEntity::getTotalProdutos).reduce(BigDecimal.ZERO, BigDecimal::add);
		
		if(BigDecimal.ZERO.compareTo(total) >= 0) throw new GpedidosException("A soma total dos pedidos foi menor ou igual a zero");
		
		return total;
		
	}
	
	private void salvar(PedidoEntity novoPedido, List<ProdutoPedidoEntity> novosProdutosPedidos, BigDecimal totalPedido) {

		novoPedido.setTotalPedido(totalPedido);
		
		pedidosRepository.save(novoPedido);
		
		novosProdutosPedidos.forEach(npp -> npp.setPedido(novoPedido));

		produtosPedidosRepository.saveAll(novosProdutosPedidos);
		
	}
}
