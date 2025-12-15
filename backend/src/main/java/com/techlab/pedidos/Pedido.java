package com.techlab.pedidos;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private boolean confirmado = false;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LineaPedido> lineas = new ArrayList<>();

    public Pedido() {}

    public void agregarLinea(LineaPedido linea) {
        lineas.add(linea);
    }

    public double getTotal() {
        double total = 0;
        for (LineaPedido lp : lineas) {
            total += lp.getSubtotal();
        }
        return total;
    }

    public Integer getId() { return id; }
    public boolean isConfirmado() { return confirmado; }
    public List<LineaPedido> getLineas() { return lineas; }

    public void setConfirmado(boolean confirmado) { this.confirmado = confirmado; }
}
