package com.lab.apis.controllers;
import com.lab.apis.models.Cliente;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    private List<Cliente> clientes = new ArrayList<>();

    public ClienteController() {
        clientes.add(new Cliente(1, "Carlos", "Ramírez", "carlos@gmail.com", "5551-2233"));
        clientes.add(new Cliente(2, "María", "López", "maria@gmail.com", "5552-3344"));
        clientes.add(new Cliente(3, "José", "Martínez", "jose@gmail.com", "5553-4455"));
        clientes.add(new Cliente(4, "Ana", "García", "ana@gmail.com", "5554-5566"));
        clientes.add(new Cliente(5, "Luis", "Hernández", "luis@gmail.com", "5555-6677"));
    }

    @GetMapping
    public List<Cliente> obtenerClientes() {
        return clientes;
    }

    @GetMapping("/{id}")
    public Cliente obtenerClientePorId(@PathVariable int id) {
        return clientes.stream().filter(c -> c.getId() == id).findFirst().orElse(null);
    }

    @PostMapping
    public Cliente crearCliente(@RequestBody Cliente nuevoCliente) {
        clientes.add(nuevoCliente);
        return nuevoCliente;
    }

    @PutMapping("/{id}")
    public Cliente actualizarCliente(@PathVariable int id, @RequestBody Cliente clienteActualizado) {
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getId() == id) {
                clientes.set(i, clienteActualizado);
                return clienteActualizado;
            }
        }
        return null;
    }

    @PatchMapping("/{id}")
    public Cliente actualizarParcial(@PathVariable int id, @RequestBody Map<String, Object> cambios) {
        for (Cliente c : clientes) {
            if (c.getId() == id) {

                if (cambios.containsKey("nombre"))
                    c.setNombre((String) cambios.get("nombre"));

                if (cambios.containsKey("apellido"))
                    c.setApellido((String) cambios.get("apellido"));

                if (cambios.containsKey("correo"))
                    c.setCorreo((String) cambios.get("correo"));

                if (cambios.containsKey("telefono"))
                    c.setTelefono((String) cambios.get("telefono"));

                return c;
            }
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public String eliminarCliente(@PathVariable int id) {
        clientes.removeIf(c -> c.getId() == id);
        return "Cliente eliminado";
    }
}