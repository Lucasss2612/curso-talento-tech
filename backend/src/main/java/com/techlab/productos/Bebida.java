package com.techlab.productos;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("BEBIDA")
public class Bebida extends Producto {

    private double litros;

    public Bebida() {}

    public Bebida(String nombre, String desc, double precio, int stock, String image, double litros) {
        super(nombre, desc, precio, stock, image);
        this.litros = litros;
    }

    public double getLitros() { return litros; }
    public void setLitros(double litros) { this.litros = litros; }
}
