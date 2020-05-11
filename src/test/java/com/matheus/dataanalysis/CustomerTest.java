package com.matheus.dataanalysis;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.matheus.dataanalysis.model.Customer;
import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    private Customer customer;

    @BeforeEach 
    void setUp() {
        this.customer = new Customer("2345675434544345", "Jose da Silva", "Rural");
    }

    @Test
    void getCnpj() {
        assertEquals("2345675434544345", this.customer.getCnpj());
    }

    @Test
    void setCnpj() {
        this.customer.setCnpj("12345");
        assertEquals("12345", this.customer.getCnpj());
    }

    @Test
    void getName() {
        assertEquals("Jose da Silva", this.customer.getName());
    }

    @Test
    void setName() {
        this.customer.setName("Teste");
        assertEquals("Teste", this.customer.getName());
    }

    @Test
    void getBusinessArea() {
        assertEquals("Rural", this.customer.getBusinessArea());
    }

    @Test
    void setBusinessArea() {
        this.customer.setBusinessArea("TI");
        assertEquals("TI", this.customer.getBusinessArea());
    }

}
