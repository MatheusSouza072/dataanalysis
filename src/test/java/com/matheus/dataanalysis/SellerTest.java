package com.matheus.dataanalysis;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.matheus.dataanalysis.model.Seller;

import static org.junit.jupiter.api.Assertions.*;

class SellerTest {

    private Seller seller;

    @BeforeEach
    void setUp() {
        this.seller = new Seller("1234567891234","Pedro", 50000);
    }

    @Test
    void testGetCpf() {
        assertEquals("1234567891234", this.seller.getCpf());
    }

    @Test
    void testSetCpf() {
        this.seller.setCpf("12345");
        assertEquals("12345", this.seller.getCpf());
    }

    @Test
    void getName() {
        assertEquals("Pedro", this.seller.getName());
    }

    @Test
    void setName() {
        this.seller.setName("Test");
        assertEquals("Test", this.seller.getName());
    }

    @Test
    void getSalary() {
        assertEquals(50000, this.seller.getSalary());
    }

    @Test
    void setSalary() {
        this.seller.setSalary(1000);
        assertEquals(1000, this.seller.getSalary());
    } 
}