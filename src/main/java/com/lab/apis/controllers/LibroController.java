package com.lab.apis.controllers;
import com.lab.apis.models.Libro;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/libros")
public class LibroController {
    private List<Libro> libros = new ArrayList<>();

    public LibroController(){
        libros.add(new Libro(1, "Principito", "Antoine de Saint", "Fantasia", 300.00));
        libros.add(new Libro(2, "Don Quijote", "Miguel de Cervantes", "Satira", 200.00));
        libros.add(new Libro(3, "Cien años de soledad", "Gabriel Garcia Marquez", "Realismo magico", 150.00));
        libros.add(new Libro(4, "El libro troll", "elrubiusOMG", "Comedia", 400.00));
        libros.add(new Libro(5, "Wigetta", "Vegetta 777 y Willyrex", "Fantasia", 150.00));
    }

    @GetMapping
    public List<Libro> obtenerLibros(){
        return libros;
    }

    @GetMapping("/{id}")
    public Libro obtenerLibroPorId(@PathVariable int id){
        return libros.stream().filter(p -> p.getId()== id).findFirst().orElse(null);
    }

    @PostMapping
    public Libro crearLibro(@RequestBody Libro nuevoLibro){
        libros.add(nuevoLibro);
        return nuevoLibro;
    }

    @PutMapping("/{id}")
    public Libro actualizarLibro(@PathVariable int id, @RequestBody Libro libroAactualizado){
        for(int i = 0; i< libros.size();i++){
            if(libros.get(i).getId() == id){
                libros.set(i, libroAactualizado);
                return libroAactualizado;
            }
        }
        return null;
    }

    @PatchMapping("/{id}")
    public Libro updateLibro(@PathVariable int id, @RequestBody Map<String, Object> cambios){
        for(Libro l : libros){
            if(l.getId() == id){
                if(cambios.containsKey("titulo"))
                    l.setTitulo((String) cambios.get("titulo"));
                if(cambios.containsKey("autor"))
                    l.setAutor((String) cambios.get("autor"));
                if(cambios.containsKey("genero"))
                    l.setGenero((String) cambios.get("genero"));
                if(cambios.containsKey("precio"))
                    l.setPrecio(Double.valueOf(cambios.get("precio").toString()));
                return l;
            }
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public String eliminarEstudiante(@PathVariable int id){
        libros.removeIf(p -> p.getId()==id);
        return "Libro eliminado";
    }
}
