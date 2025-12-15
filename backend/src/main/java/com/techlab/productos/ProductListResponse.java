package com.techlab.productos;

import java.util.List;

public class ProductListResponse {

    private List<Producto> products;

    public ProductListResponse(List<Producto> products) {
        this.products = products;
    }

    public List<Producto> getProducts() { return products; }
    public void setProducts(List<Producto> products) { this.products = products; }
}
