package com.techlab.productos;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    private String nombre;

    private String description;

    @Positive
    private double precio;

    @Min(0)
    private int stock;

    private String image;

    private boolean activo = true;

    public Producto() {}

    public Producto(String nombre, String description, double precio, int stock, String image) {
        this.nombre = nombre;
        this.description = description;
        this.precio = precio;
        this.stock = stock;
        this.image = image;
        this.activo = true;
    }

    // ======================
    // GETTERS y SETTERS
    // ======================

    public Integer getId() { return id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }

    public int getStock() { return stock; }
    public void setStock(int stock) { this.stock = stock; }

    public String getImage() { return image; }
    public void setImage(String image) { this.image = image; }

    public boolean isActivo() { return activo; }
    public void setActivo(boolean activo) { this.activo = activo; }

    // ALIAS para que tu FRONTEND pueda usar title y price como DummyJSON

    public String getTitle() { return nombre; }
    public void setTitle(String title) { this.nombre = title; }

    public double getPrice() { return precio; }
    public void setPrice(double price) { this.precio = price; }
}
