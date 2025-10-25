package com.techlab.pedidos;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private static int contador = 1;
    private int id;
    private List<LineaPedido> lineas = new ArrayList<>();

    public Pedido() {
        this.id = contador++;
    }

    public void agregarLinea(LineaPedido lp) {
        lineas.add(lp);
    }

    public double calcularTotal() {
        double total = 0;
        for (LineaPedido lp : lineas) {
            total += lp.getSubtotal(); // operador +=
        }
        return total;
    }

    public void mostrarPedido() {
        System.out.println("\nPedido #" + id);
        for (LineaPedido lp : lineas) {
            System.out.println(" - " + lp);
        }
        System.out.println("Total: $" + calcularTotal());
    }
}
