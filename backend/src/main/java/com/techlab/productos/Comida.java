package com.techlab.productos;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("COMIDA")
public class Comida extends Producto {

    private String fechaVencimiento;

    public Comida() {}

    public Comida(String nombre, String desc, double precio, int stock, String image, String fechaVencimiento) {
        super(nombre, desc, precio, stock, image);
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getFechaVencimiento() { return fechaVencimiento; }
    public void setFechaVencimiento(String fechaVencimiento) { this.fechaVencimiento = fechaVencimiento; }
}
