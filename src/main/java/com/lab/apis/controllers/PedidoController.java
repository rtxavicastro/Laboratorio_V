package com.lab.apis.controllers;
import com.lab.apis.models.Pedido;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    private List<Pedido> pedidos = new ArrayList<>();

    public PedidoController() {
        pedidos.add(new Pedido(1, "Carlos Ramírez", "Laptop Lenovo", 1, 4500.00, "Pendiente"));
        pedidos.add(new Pedido(2, "María López", "Mouse Logitech", 2, 300.00, "Completado"));
        pedidos.add(new Pedido(3, "José Martínez", "Monitor Samsung", 1, 1200.00, "En proceso"));
        pedidos.add(new Pedido(4, "Ana García", "Teclado Mecánico", 1, 350.00, "Pendiente"));
        pedidos.add(new Pedido(5, "Luis Hernández", "Silla Gamer", 1, 900.00, "Cancelado"));
    }

    @GetMapping
    public List<Pedido> obtenerPedidos() {
        return pedidos;
    }

    @GetMapping("/{id}")
    public Pedido obtenerPedidoPorId(@PathVariable int id) {
        return pedidos.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
    }

    @PostMapping
    public Pedido crearPedido(@RequestBody Pedido nuevoPedido) {
        pedidos.add(nuevoPedido);
        return nuevoPedido;
    }

    @PutMapping("/{id}")
    public Pedido actualizarPedido(@PathVariable int id, @RequestBody Pedido pedidoActualizado) {
        for (int i = 0; i < pedidos.size(); i++) {
            if (pedidos.get(i).getId() == id) {
                pedidos.set(i, pedidoActualizado);
                return pedidoActualizado;
            }
        }
        return null;
    }

    @PatchMapping("/{id}")
    public Pedido actualizarParcial(@PathVariable int id, @RequestBody Map<String, Object> cambios) {
        for (Pedido p : pedidos) {
            if (p.getId() == id) {

                if (cambios.containsKey("cliente"))
                    p.setCliente((String) cambios.get("cliente"));

                if (cambios.containsKey("producto"))
                    p.setProducto((String) cambios.get("producto"));

                if (cambios.containsKey("cantidad"))
                    p.setCantidad(Integer.valueOf(cambios.get("cantidad").toString()));

                if (cambios.containsKey("total"))
                    p.setTotal(Double.valueOf(cambios.get("total").toString()));

                if (cambios.containsKey("estado"))
                    p.setEstado((String) cambios.get("estado"));

                return p;
            }
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public String eliminarPedido(@PathVariable int id) {
        pedidos.removeIf(p -> p.getId() == id);
        return "Pedido eliminado";
    }
}
