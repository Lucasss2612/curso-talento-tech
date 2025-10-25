package com.techlab.app;

import com.techlab.servicio.TiendaService;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TiendaService tienda = new TiendaService();
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n===== MENÚ PRINCIPAL =====");
            System.out.println("1. Agregar producto");
            System.out.println("2. Listar productos");
            System.out.println("3. Crear pedido");
            System.out.println("4. Listado pedidos");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            
            try {
                opcion = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("⚠️ Ingrese un número valido.");
                opcion = -1;
            }

            switch (opcion) {
                case 1 -> tienda.agregarProducto();
                case 2 -> tienda.listarProductos();
                case 3 -> tienda.crearPedido();
                case 4 -> tienda.listarPedidos();
                case 0 -> System.out.println("👋 Saliendo.");
                default -> System.out.println("Opción inválida.");
            }
        } while (opcion != 0);

        sc.close();
    }
}
