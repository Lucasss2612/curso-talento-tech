package com.techlab.pedidos.dto;

import java.util.Map;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;

public class CreatePedidoDTO {

    @NotEmpty
    private Map<Integer, @Min(1) Integer> items;

    public Map<Integer, Integer> getItems() { return items; }
    public void setItems(Map<Integer, Integer> items) { this.items = items; }
}
