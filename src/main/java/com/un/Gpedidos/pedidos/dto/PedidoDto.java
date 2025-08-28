package com.un.Gpedidos.pedidos.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class PedidoDto {
	
    private Long id;

    private LocalDate dataPedido;

    private BigDecimal totalPedido;

    private String nomeConsumidor;
    
    private List<ProdutoPedidoDto> produtos;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(LocalDate dataPedido) {
		this.dataPedido = dataPedido;
	}

	public BigDecimal getTotalPedido() {
		return totalPedido;
	}

	public void setTotalPedido(BigDecimal totalPedido) {
		this.totalPedido = totalPedido;
	}

	public String getNomeConsumidor() {
		return nomeConsumidor;
	}

	public void setNomeConsumidor(String nomeConsumidor) {
		this.nomeConsumidor = nomeConsumidor;
	}

	public List<ProdutoPedidoDto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<ProdutoPedidoDto> produtos) {
		this.produtos = produtos;
	}
}
