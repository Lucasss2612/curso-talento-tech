package com.techlab.servicio;

import com.techlab.productos.*;
import com.techlab.pedidos.*;
import com.techlab.excepciones.StockInsuficienteException;

import java.util.*;

public class TiendaService {
    private List<Producto> productos = new ArrayList<>();
    private List<Pedido> pedidos = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    public void agregarProducto() {
        System.out.print("Tipo de producto (1=Bebida, 2=Comida, otro=Genérico): ");
        int tipo = sc.nextInt();
        sc.nextLine();

        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Precio: ");
        double precio = sc.nextDouble();
        System.out.print("Stock: ");
        int stock = sc.nextInt();
        sc.nextLine();

        Producto p;
        if (tipo == 1) {
            System.out.print("Litros: ");
            double litros = sc.nextDouble();
            sc.nextLine();
            p = new Bebida(nombre, precio, stock, litros);
        } else if (tipo == 2) {
            System.out.print("Fecha de vencimiento (dd/mm/aaaa): ");
            String fecha = sc.nextLine();
            p = new Comida(nombre, precio, stock, fecha);
        } else {
            p = new Producto(nombre, precio, stock);
        }

        productos.add(p);
        System.out.println("✅ Producto agregado correctamente.");
    }

    public void listarProductos() {
        if (productos.isEmpty()) {
            System.out.println("No hay productos cargados.");
            return;
        }
        System.out.println("\n📦 Lista de productos:");
        for (Producto p : productos) System.out.println(p);
    }

    public Producto buscarPorId(int id) {
        for (Producto p : productos) {
            if (p.getId() == id) return p;
        }
        return null;
    }

    public void crearPedido() {
        if (productos.isEmpty()) {
            System.out.println("No hay productos disponibles.");
            return;
        }

        Pedido pedido = new Pedido();

        while (true) {
            listarProductos();
            System.out.print("Ingrese ID del producto (0 para finalizar): ");
            int id = 0;
            try {
                id = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("⚠️ Debe ingresar un número válido.");
                continue;
            }

            if (id == 0) break;

            Producto p = buscarPorId(id);
            if (p == null) {
                System.out.println("❌ Producto no encontrado.");
                continue;
            }

            System.out.print("Cantidad deseada: ");
            int cantidad = sc.nextInt();
            sc.nextLine();

            try {
                if (cantidad <= 0 || cantidad > p.getStock()) {
                    throw new StockInsuficienteException("Stock insuficiente para " + p.getNombre());
                }

                p.setStock(p.getStock() - cantidad); // operador aritmético
                pedido.agregarLinea(new LineaPedido(p, cantidad));

            } catch (StockInsuficienteException e) {
                System.out.println("⚠️ " + e.getMessage());
            }
        }

        pedidos.add(pedido);
        System.out.println("✅ Pedido creado correctamente.");
        pedido.mostrarPedido();
    }

    public void listarPedidos() {
        if (pedidos.isEmpty()) {
            System.out.println("No hay pedidos registrados.");
            return;
        }
        for (Pedido ped : pedidos) ped.mostrarPedido();
    }
}
