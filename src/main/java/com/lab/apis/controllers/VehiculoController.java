package com.lab.apis.controllers;
import com.lab.apis.models.Vehiculo;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/vehiculos")
public class VehiculoController {

    private List<Vehiculo> vehiculos = new ArrayList<>();

    public VehiculoController() {
        vehiculos.add(new Vehiculo(1, "Toyota", "Corolla", 2020, 95000.00));
        vehiculos.add(new Vehiculo(2, "Honda", "Civic", 2019, 88000.00));
        vehiculos.add(new Vehiculo(3, "Ford", "Mustang", 2022, 250000.00));
        vehiculos.add(new Vehiculo(4, "Chevrolet", "Camaro", 2021, 230000.00));
        vehiculos.add(new Vehiculo(5, "Nissan", "Sentra", 2018, 70000.00));
    }

    @GetMapping
    public List<Vehiculo> obtenerVehiculos() {
        return vehiculos;
    }

    @GetMapping("/{id}")
    public Vehiculo obtenerVehiculoPorId(@PathVariable int id) {
        return vehiculos.stream().filter(v -> v.getId() == id).findFirst().orElse(null);
    }

    @PostMapping
    public Vehiculo crearVehiculo(@RequestBody Vehiculo nuevoVehiculo) {
        vehiculos.add(nuevoVehiculo);
        return nuevoVehiculo;
    }

    @PutMapping("/{id}")
    public Vehiculo actualizarVehiculo(@PathVariable int id, @RequestBody Vehiculo vehiculoActualizado) {
        for (int i = 0; i < vehiculos.size(); i++) {
            if (vehiculos.get(i).getId() == id) {
                vehiculos.set(i, vehiculoActualizado);
                return vehiculoActualizado;
            }
        }
        return null;
    }

    @PatchMapping("/{id}")
    public Vehiculo actualizarParcial(@PathVariable int id, @RequestBody Map<String, Object> cambios) {
        for (Vehiculo v : vehiculos) {
            if (v.getId() == id) {
                if (cambios.containsKey("marca"))
                    v.setMarca((String) cambios.get("marca"));
                if (cambios.containsKey("modelo"))
                    v.setModelo((String) cambios.get("modelo"));
                if (cambios.containsKey("anio"))
                    v.setAnio(Integer.valueOf(cambios.get("anio").toString()));
                if (cambios.containsKey("precio"))
                    v.setPrecio(Double.valueOf(cambios.get("precio").toString()));
                return v;
            }
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public String eliminarVehiculo(@PathVariable int id) {
        vehiculos.removeIf(v -> v.getId() == id);
        return "Vehículo eliminado";
    }
}
