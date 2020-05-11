package com.matheus.dataanalysis;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.matheus.dataanalysis.model.Item;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {

	private Item item;

	@BeforeEach
	void setUp() {
		this.item = new Item(1, 5, 10);
	}

	@Test
	void getId() {
		assertEquals(1, this.item.getId());
	}

	@Test
	void setId() {
		this.item.setId(2);
		assertEquals(2, this.item.getId());
	}

	@Test
	void getQuantity() {
		assertEquals(5, this.item.getQuantity());
	}

	@Test
	void setQuantity() {
		this.item.setQuantity(10);
		assertEquals(10, this.item.getQuantity());
	}

	@Test
	void getPrice() {
		assertEquals(10, this.item.getPrice());
	}

	@Test
	void setPrice() {
		this.item.setPrice(15);
		assertEquals(15, this.item.getPrice());
	}

	@Test
	void getTotal() {
		assertEquals(50, this.item.getTotal());
	}
}