package com.techlab.servicio;

import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.techlab.productos.ProductListResponse;
import com.techlab.productos.Producto;
import com.techlab.productos.ProductoRepository;

import jakarta.validation.Valid;

@Service
public class ProductoService {

    private final ProductoRepository repo;

    public ProductoService(ProductoRepository repo) {
        this.repo = repo;
    }

    public ProductListResponse listarTodos() {
        return new ProductListResponse(repo.findAll());
    }

    public Producto crear(@Valid Producto p) {
        return repo.save(p);
    }

    public Producto obtener(int id) {
        return repo.findById(id)
                .orElseThrow(() -> new NoSuchElementException("No existe producto con id " + id));
    }

    public Producto actualizar(int id, @Valid Producto datos) {
        Producto p = obtener(id);

        if (datos.getPrecio() > 0) p.setPrecio(datos.getPrecio());
        if (datos.getStock() >= 0) p.setStock(datos.getStock());
        if (datos.getNombre() != null && !datos.getNombre().isBlank()) p.setNombre(datos.getNombre());
        if (datos.getDescription() != null) p.setDescription(datos.getDescription());
        if (datos.getImage() != null) p.setImage(datos.getImage());

        p.setActivo(datos.isActivo());

        return repo.save(p);
    }

    public void eliminar(int id) {
        repo.delete(obtener(id));
    }
}
