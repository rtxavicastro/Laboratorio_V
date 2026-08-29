package com.lab.apis.controllers;
import com.lab.apis.models.Estudiante;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api/estudiantes")
public class EstudianteController {
    private List<Estudiante> estudiantes = new ArrayList<>();

    public EstudianteController(){
        estudiantes.add(new Estudiante(1, "Xavier", "Quina", "Ingenieria en sistemas", 23));
        estudiantes.add(new Estudiante(2, "Jimena", "Calan", "Psicologia industrial", 20));
        estudiantes.add(new Estudiante(3, "Maria", "Perla", "Medicina General", 20));
        estudiantes.add(new Estudiante(4, "Selvyn", "Castro", "Ingenieria Civil", 23));
        estudiantes.add(new Estudiante(5, "David", "Herrera", "Musica", 19));
    }

    @GetMapping
    public List<Estudiante> obtenerEstudiantes(){
        return estudiantes;
    }

    @GetMapping("/{id}")
    public Estudiante obtenerEstudiantePorId(@PathVariable int id){
        return estudiantes.stream().filter(p -> p.getId()== id).findFirst().orElse(null);
    }

    @PostMapping
    public Estudiante crearEstudiante(@RequestBody Estudiante nuevoEstudiante){
        estudiantes.add(nuevoEstudiante);
        return nuevoEstudiante;
    }

    @PutMapping("/{id}")
    public Estudiante actualizarEstudiante(@PathVariable int id, @RequestBody Estudiante estudianteActualizado){
        for(int i = 0; i < estudiantes.size(); i++){
            if(estudiantes.get(i).getId() == id){
                estudiantes.set(i, estudianteActualizado);
                return estudianteActualizado;
            }
        }
        return null;
    }
    
    @PatchMapping("/{id}")
    public Estudiante updateEstudiante(@PathVariable int id, @RequestBody Map<String, Object> cambios){
        for(Estudiante e : estudiantes){
            if(e.getId() == id){
                if(cambios.containsKey("nombre"))
                    e.setNombre((String) cambios.get("nombre"));
                if(cambios.containsKey("apellido"))
                    e.setApellido((String) cambios.get("apellido"));
                if(cambios.containsKey("carrera"))
                    e.setCarrera((String) cambios.get("carrera"));
                if(cambios.containsKey("edad"))
                    e.setEdad((int) cambios.get("edad"));
                return e;
            }
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public String eliminarEstudiante(@PathVariable int id){
        estudiantes.removeIf(p -> p.getId() == id);
        return "Estudiante eliminado";
    }
}
