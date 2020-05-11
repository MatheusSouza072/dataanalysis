package com.matheus.dataanalysis.model;

import java.util.List;

public class Sale {

    private int id;
    private List<Item> itens;
    private String sellerName;

    public Sale(int id, List<Item> itens, String sellerName) {
        this.id = id;
        this.itens = itens;
        this.sellerName = sellerName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Item> getItens() {
        return itens;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    } 


    public double getTotal() {
        double total = 0;

        if(!itens.isEmpty()) {
            total = itens.stream().mapToDouble(Item::getTotal).sum();
        }

        return total;
    }
}
