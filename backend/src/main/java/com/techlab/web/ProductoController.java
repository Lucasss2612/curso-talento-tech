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

    // GET http://localhost:8080/api/products
    @GetMapping
    public ProductListResponse listar() {
        return service.listarTodos();
    }

    // POST http://localhost:8080/api/products
    @PostMapping
    public Producto crear(@Valid @RequestBody Producto producto) {
        return service.crear(producto);
    }

    // GET http://localhost:8080/api/products/{id}
    @GetMapping("/{id}")
    public Producto obtener(@PathVariable int id) {
        return service.obtener(id);
    }

    // PUT http://localhost:8080/api/products/{id}
    @PutMapping("/{id}")
    public Producto actualizar(
            @PathVariable int id,
            @Valid @RequestBody Producto producto
    ) {
        return service.actualizar(id, producto);
    }

    // DELETE http://localhost:8080/api/products/{id}
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable int id) {
        service.eliminar(id);
    }
}
