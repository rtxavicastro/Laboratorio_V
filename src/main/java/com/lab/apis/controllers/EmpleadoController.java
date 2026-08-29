package com.lab.apis.controllers;
import com.lab.apis.models.Empleado;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/empleados")
public class EmpleadoController {
    private List<Empleado> empleados = new ArrayList<>();

    public EmpleadoController(){
        empleados.add(new Empleado(1, "Xavier Quina", "Ciberseguridad", 7500.00, "IT"));
        empleados.add(new Empleado(2, "Jimena Calan", "Soporte Tecnico", 7500.00, "IT"));
        empleados.add(new Empleado(3, "Maria Perla", "Contador", 6500.00, "Contabilidad"));
        empleados.add(new Empleado(4, "Paola Quina", "Supervidor de planta", 9000.00, "Administracion"));
        empleados.add(new Empleado(5, "Cristy Quina", "Medico ocupacional", 7500.00, "Enfermeria"));
    }

    @GetMapping
    public List<Empleado> obtenerEmpleados(){
        return empleados;
    }

    @GetMapping("/{id}")
    public Empleado obtenerEmpleadoPorId(@PathVariable int id){
        return empleados.stream().filter(p-> p.getId() == id).findFirst().orElse(null);
    }

    @PostMapping
    public Empleado crearEmpleado(@RequestBody Empleado nuevoEmpleado){
        empleados.add(nuevoEmpleado);
        return nuevoEmpleado;
    }

    @PutMapping("/{id}")
    public Empleado actualizarEmpleado(@PathVariable int id, @RequestBody Empleado empleadoActualizado){
        for(int i = 0; i< empleados.size(); i++){
            if(empleados.get(i).getId()==id){
                empleados.set(i, empleadoActualizado);
                return empleadoActualizado;
            }
        }
        return null;
    }

    @PatchMapping("/{id}")
    public Empleado updateEmpleado(@PathVariable int id, @RequestBody Map<String, Object> cambios){
        for(Empleado e : empleados){
            if(e.getId() == id){
                if(cambios.containsKey("nombre"))
                    e.setNombre((String) cambios.get("nombre"));
                if(cambios.containsKey("puesto"))
                    e.setPuesto((String) cambios.get("puesto"));
                if(cambios.containsKey("salario"))
                    e.setSalario(Double.valueOf(cambios.get("salario").toString()));
                if(cambios.containsKey("departamento"))
                    e.setDepartamento((String) cambios.get("departamento"));
                return e;
            }
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public String eliminarEmpleado(@PathVariable int id){
        empleados.removeIf(p -> p.getId() == id);
        return "Empleado eliminado";
    }
}
