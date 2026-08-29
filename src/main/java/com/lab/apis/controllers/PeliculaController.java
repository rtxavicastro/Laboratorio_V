package com.lab.apis.controllers;
import com.lab.apis.models.Pelicula;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/peliculas")
public class PeliculaController {
    private List<Pelicula> peliculas = new ArrayList<>();

    public PeliculaController(){
        peliculas.add(new Pelicula(1, "El caballero de la noche", "Christopher Nolan", "Accion", 2018));
        peliculas.add(new Pelicula(2, "Spider-man 2", "Sam Raimi", "Accion", 2004));
        peliculas.add(new Pelicula(3, "Interestellar", "Christopher Nolan", "Ciencia ficcion", 2014));
        peliculas.add(new Pelicula(4, "Dune 2", "Denis Villeneuve", "Accion", 2024));
        peliculas.add(new Pelicula(5, "Pulp Fiction", "Quentin Tarantino", "Comedia negra", 1994));
    }

    @GetMapping
    public List<Pelicula> obtenerPeliculas(){
        return peliculas;
    }

    @GetMapping("/{id}")
    public Pelicula obtenerPeliculaPorId(@PathVariable int id){
        return peliculas.stream().filter(p -> p.getId()== id).findFirst().orElse(null);
    }

    @PostMapping
    public Pelicula crearPelicula(@RequestBody Pelicula nuevaPelicula){
        peliculas.add(nuevaPelicula);
        return nuevaPelicula;
    }

    @PutMapping("/{id}")
    public Pelicula actualizarPelicula(@PathVariable int id, @RequestBody Pelicula peliculaActualizada){
        for(int i = 0; i< peliculas.size(); i++){
            if(peliculas.get(i).getId()==id){
                peliculas.set(i, peliculaActualizada);
                return peliculaActualizada;
            }
        }
        return null;
    }

    @PatchMapping("/{id}")
    public Pelicula updatePelicula(@PathVariable int id, @RequestBody Map<String, Object> cambios){
        for(Pelicula p : peliculas){
            if(p.getId()==id){
                if(cambios.containsKey("titulo"))
                    p.setTitulo((String) cambios.get("titulo"));
                if(cambios.containsKey("director"))
                    p.setDirector((String) cambios.get("director"));
                if(cambios.containsKey("genero"))
                    p.setGenero((String) cambios.get("genero"));
                if(cambios.containsKey("anio"))
                    p.setAnio(Integer.valueOf(cambios.get("anio").toString()));
                return p;
            }
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public String eliminarPelicula(@PathVariable int id){
        peliculas.removeIf(p -> p.getId() == id);
        return "Pelicula eliminada";
    }
}
