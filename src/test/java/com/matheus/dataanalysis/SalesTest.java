package com.matheus.dataanalysis;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.matheus.dataanalysis.model.Item;
import com.matheus.dataanalysis.model.Sale;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SalesTest {

	private Sale sale;

	@BeforeEach
	void setUp() {
		List<Item> itens = new ArrayList<>();
		itens.add(new Item(1, 10, 100));
		this.sale = new Sale(1, itens, "Pedro");
	}

	@Test
	void getId() {
		assertEquals(1, this.sale.getId());
	}

	@Test
	void setId() { 
		this.sale.setId(2);
		assertEquals(2, this.sale.getId());
	} 

	@Test
	void getItensCount() {
		assertEquals(1, this.sale.getItens().size());
	}

	@Test
	void setItens() {
		List<Item> itens = new ArrayList<>();
		itens.add(new Item(1, 1, 10));
		itens.add(new Item(1, 3, 15));
		this.sale.setItens(itens);

		assertEquals(2, this.sale.getItens().size());
		assertEquals(15, this.sale.getItens().get(1).getPrice());
	}

	@Test
	void getSellerName() {
		assertEquals("Pedro", this.sale.getSellerName());
	}

	@Test
	void setSellerName() {
		this.sale.setSellerName("Test");
		assertEquals("Test", this.sale.getSellerName());
	}

	@Test
	void getTotal() {
		assertEquals(1000, this.sale.getTotal());
	} 
}