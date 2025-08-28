package com.un.Gpedidos.pedidos.entity;

import java.math.BigDecimal;

import com.un.Gpedidos.produtos.entity.ProdutoEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "PRODUTOS_PEDIDOS")
public class ProdutoPedidoEntity {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(name = "MOEDA", nullable = false, length = 31)
	private String moeda;

	@Column(name = "QTD")
	private Integer quantidade;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "PRODUTO_ID", referencedColumnName = "id")
	ProdutoEntity produto;
	
	@ManyToOne
    @JoinColumn(name = "PEDIDO_ID", referencedColumnName = "id")
	PedidoEntity pedido;
	
	@Column(name = "TOTAL_PRODUTO")
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

	public ProdutoEntity getProduto() {
		return produto;
	}

	public void setProduto(ProdutoEntity produto) {
		this.produto = produto;
	}

	public PedidoEntity getPedido() {
		return pedido;
	}

	public void setPedido(PedidoEntity pedido) {
		this.pedido = pedido;
	}

	public BigDecimal getTotalProdutos() {
		return totalProdutos;
	}

	public void setTotalProdutos(BigDecimal totalProdutos) {
		this.totalProdutos = totalProdutos;
	}
	
}
