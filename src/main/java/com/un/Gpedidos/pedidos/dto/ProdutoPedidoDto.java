package com.un.Gpedidos.pedidos.dto;

import java.math.BigDecimal;

import com.un.Gpedidos.produtos.dto.ProdutoDto;

public class ProdutoPedidoDto {

    private Long id;
	
	private String moeda;

	private Integer quantidade;
	
	ProdutoDto produto;
	
    private BigDecimal totalProdutos;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMoeda() {
		return moeda;
	}

	public void setMoeda(String moeda) {
		this.moeda = moeda;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public ProdutoDto getProduto() {
		return produto;
	}

	public void setProduto(ProdutoDto produto) {
		this.produto = produto;
	}

	public BigDecimal getTotalProdutos() {
		return totalProdutos;
	}

	public void setTotalProdutos(BigDecimal totalProdutos) {
		this.totalProdutos = totalProdutos;
	}
}
