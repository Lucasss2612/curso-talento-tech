package com.techlab.productos;

public class Producto {
    private static int contador = 1;
    protected int id;
    protected String nombre;
    protected double precio;
    protected int stock;

    public Producto(String nombre, double precio, int stock) {
        this.id = contador++;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    // Getters y setters
    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public double getPrecio() { return precio; }
    public int getStock() { return stock; }

    public void setPrecio(double precio) {
        if (precio > 0) this.precio = precio;
    }

    public void setStock(int stock) {
        if (stock >= 0) this.stock = stock;
    }

    @Override
    public String toString() {
        return id + " | " + nombre + " | $" + precio + " | Stock: " + stock;
    }
}
