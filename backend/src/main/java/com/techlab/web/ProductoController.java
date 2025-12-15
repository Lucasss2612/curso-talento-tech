package com.techlab.web;

import com.techlab.productos.ProductListResponse;
import com.techlab.productos.Producto;
import com.techlab.servicio.ProductoService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "*")
public class ProductoController {

    private final ProductoService service;

    public ProductoController(ProductoService service) {
        this.service = service;
    }

    @GetMapping
    public ProductListResponse listar() {
        return service.listarTodos();
    }

    @PostMapping
    public Producto crear(@Valid @RequestBody Producto producto) {
        return service.crear(producto);
    }

    @GetMapping("/{id}")
    public Producto obtener(@PathVariable int id) {
        return service.obtener(id);
    }

    @PutMapping("/{id}")
    public Producto actualizar(
            @PathVariable int id,
            @Valid @RequestBody Producto producto
    ) {
        return service.actualizar(id, producto);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable int id) {
        service.eliminar(id);
    }
}
