package com.lab.apis.controllers;
import com.lab.apis.models.Curso;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/cursos")
public class CursoController {
    private List<Curso> cursos = new ArrayList<>();

    public CursoController(){
        cursos.add(new Curso(1, "Matematicas", "Matematicas nivel medio", 4, "Presencial"));
        cursos.add(new Curso(2, "Fisica", "Fisica nivel medio", 4, "Presencial"));
        cursos.add(new Curso(3, "Programacion", "Programacion Java", 5, "En linea"));
        cursos.add(new Curso(4, "Contabilidad", "Contabilidad nivel dos", 6, "Presencial"));
        cursos.add(new Curso(5, "Calculo", "Calculo nivel dos", 4, "En linea"));
    }

    @GetMapping
    public List<Curso> obtenerCursos(){
        return cursos;
    }

    @GetMapping("/{id}")
    public Curso obtenerCursoPorId(@PathVariable int id){
        return cursos.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
    }

    @PostMapping
    public Curso crearCurso(@RequestBody Curso nuevoCurso){
        cursos.add(nuevoCurso);
        return nuevoCurso;
    }

    @PutMapping("/{id}")
    public Curso actualizarCurso(@PathVariable int id, @RequestBody Curso cursoActualizado){
        for(int i = 0; i< cursos.size();i++){
            if(cursos.get(i).getId() == id){
                cursos.set(i, cursoActualizado);
                return cursoActualizado;
            }
        }
        return null;
    }

    @PatchMapping("/{id}")
    public Curso updateCurso(@PathVariable int id, @RequestBody Map<String, Object> cambios){
        for(Curso c : cursos){
            if(c.getId() == id){
                if(cambios.containsKey("nombre"))
                    c.setNombre((String) cambios.get("nombre"));
                if(cambios.containsKey("descripcion"))
                    c.setDescripcion((String) cambios.get("descripcion"));
                if(cambios.containsKey("creditos"))
                    c.setCreditos(Integer.valueOf(cambios.get("creditos").toString()));
                if(cambios.containsKey("modalidad"))
                    c.setModalidad((String) cambios.get("modalidad"));
                return c;
            }
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public String borrarCurso(@PathVariable int id){
        cursos.removeIf(p-> p.getId() == id);
        return "Curso eliminado";
    }
}
