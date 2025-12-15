package com.techlab.pedidos;

import java.util.List;

public class PedidoRequest {

    private List<ItemCarritoDTO> items;

    public PedidoRequest() {
    }

    public PedidoRequest(List<ItemCarritoDTO> items) {
        this.items = items;
    }

    public List<ItemCarritoDTO> getItems() {
        return items;
    }

    public void setItems(List<ItemCarritoDTO> items) {
        this.items = items;
    }
}
