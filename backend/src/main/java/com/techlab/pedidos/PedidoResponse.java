package com.techlab.pedidos;

import java.util.List;

public class PedidoResponse {

    private Integer idPedido;
    private double total;
    private int cantidadItems;
    private List<ItemCarritoDTO> items;

    public PedidoResponse(Integer idPedido, double total, int cantidadItems, List<ItemCarritoDTO> items) {
        this.idPedido = idPedido;
        this.total = total;
        this.cantidadItems = cantidadItems;
        this.items = items;
    }

    public Integer getIdPedido() {
        return idPedido;
    }

    public double getTotal() {
        return total;
    }

    public int getCantidadItems() {
        return cantidadItems;
    }

    public List<ItemCarritoDTO> getItems() {
        return items;
    }
}
