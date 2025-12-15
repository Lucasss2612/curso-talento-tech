package com.techlab.servicio;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.techlab.excepciones.StockInsuficienteException;
import com.techlab.pedidos.ItemCarritoDTO;
import com.techlab.pedidos.LineaPedido;
import com.techlab.pedidos.Pedido;
import com.techlab.pedidos.PedidoRepository;
import com.techlab.pedidos.PedidoRequest;
import com.techlab.pedidos.PedidoResponse;
import com.techlab.productos.Producto;
import com.techlab.productos.ProductoRepository;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;
    private final ProductoRepository productoRepository;

    public PedidoService(PedidoRepository pedidoRepository, ProductoRepository productoRepository) {
        this.pedidoRepository = pedidoRepository;
        this.productoRepository = productoRepository;
    }

    @Transactional
    public PedidoResponse crearPedido(PedidoRequest request) {
        if (request == null || request.getItems() == null || request.getItems().isEmpty()) {
            throw new IllegalArgumentException("El pedido no tiene items");
        }

        Pedido pedido = new Pedido();
        pedido.setConfirmado(true);

        double total = 0.0;

        for (ItemCarritoDTO item : request.getItems()) {
            if (item.getProductId() == null) {
                throw new IllegalArgumentException("Falta productId en un item");
            }
            if (item.getQuantity() <= 0) {
                throw new IllegalArgumentException("La cantidad debe ser mayor a 0");
            }

            Producto producto = productoRepository.findById(item.getProductId())
                    .orElseThrow(() -> new IllegalArgumentException("Producto no encontrado con id " + item.getProductId()));

            if (producto.getStock() < item.getQuantity()) {
                throw new StockInsuficienteException("Stock insuficiente para el producto: " + producto.getNombre());
            }

            producto.setStock(producto.getStock() - item.getQuantity());
            productoRepository.save(producto);

            LineaPedido linea = new LineaPedido();
            linea.setProducto(producto);
            linea.setCantidad(item.getQuantity());

            // IMPORTANTE: tu Pedido debe tener getLineas()
            pedido.getLineas().add(linea);

            total += producto.getPrecio() * item.getQuantity();
        }

        Pedido guardado = pedidoRepository.save(pedido);

        return new PedidoResponse(
                guardado.getId(),
                total,
                request.getItems().size(),
                request.getItems()
        );
    }

    public List<Pedido> listarPedidos() {
        return pedidoRepository.findAll();
    }
}
