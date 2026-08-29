package com.lab.apis.controllers;
import com.lab.apis.models.Tarea;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/tareas")
public class TareaController {

    private List<Tarea> tareas = new ArrayList<>();

    public TareaController() {
        tareas.add(new Tarea(1, "Comprar comida", "Ir al supermercado por víveres", "Alta", false));
        tareas.add(new Tarea(2, "Estudiar Java", "Repasar controladores y modelos", "Media", false));
        tareas.add(new Tarea(3, "Hacer ejercicio", "Correr 30 minutos", "Baja", true));
        tareas.add(new Tarea(4, "Pagar servicios", "Electricidad y agua", "Alta", false));
        tareas.add(new Tarea(5, "Leer libro", "Terminar capítulo 4", "Media", true));
    }

    @GetMapping
    public List<Tarea> obtenerTareas() {
        return tareas;
    }

    @GetMapping("/{id}")
    public Tarea obtenerTareaPorId(@PathVariable int id) {
        return tareas.stream().filter(t -> t.getId() == id).findFirst().orElse(null);
    }

    @PostMapping
    public Tarea crearTarea(@RequestBody Tarea nuevaTarea) {
        tareas.add(nuevaTarea);
        return nuevaTarea;
    }

    @PutMapping("/{id}")
    public Tarea actualizarTarea(@PathVariable int id, @RequestBody Tarea tareaActualizada) {
        for (int i = 0; i < tareas.size(); i++) {
            if (tareas.get(i).getId() == id) {
                tareas.set(i, tareaActualizada);
                return tareaActualizada;
            }
        }
        return null;
    }

    @PatchMapping("/{id}")
    public Tarea actualizarParcial(@PathVariable int id, @RequestBody Map<String, Object> cambios) {
        for (Tarea t : tareas) {
            if (t.getId() == id) {

                if (cambios.containsKey("titulo"))
                    t.setTitulo((String) cambios.get("titulo"));

                if (cambios.containsKey("descripcion"))
                    t.setDescripcion((String) cambios.get("descripcion"));

                if (cambios.containsKey("prioridad"))
                    t.setPrioridad((String) cambios.get("prioridad"));

                if (cambios.containsKey("completada"))
                    t.setCompletada(Boolean.valueOf(cambios.get("completada").toString()));

                return t;
            }
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public String eliminarTarea(@PathVariable int id) {
        tareas.removeIf(t -> t.getId() == id);
        return "Tarea eliminada";
    }
}