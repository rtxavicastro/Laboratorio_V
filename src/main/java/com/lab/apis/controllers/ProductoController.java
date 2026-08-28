package com.lab.apis.controllers;
import com.lab.apis.models.Producto;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;



@RestController
@RequestMapping("/api/productos")
public class ProductoController {
    private List<Producto> productos = new ArrayList<>();
    
    public ProductoController(){
        productos.add(new Producto(1, "Laptop ASUS", 8500.00, "Tecnologia"));
        productos.add(new Producto(2, "Teclado Logitech", 500.00, "Accesorios de computadora"));
        productos.add(new Producto(3, "Router ASUS Rog", 4000.00, "Tecnologia"));
        productos.add(new Producto(4, "Audifonos HyperX Cloud II", 675.00, "Accesorios de computadora"));
        productos.add(new Producto(5, "Pantalla OLED AOC", 2900.00, "Accesorios de computadora"));
    }

    @GetMapping
    public List<Producto> obteneProductos(){
        return productos;
    }

    @GetMapping("/{id}")
    public Producto obteneProductoPorId(@PathVariable int id){
        return productos.stream().filter(p -> p.getId()== id).findFirst().orElse(null);
    }

    @PostMapping
    public Producto creaProducto(@RequestBody Producto nuevoProducto){
        productos.add(nuevoProducto);
        return nuevoProducto;
    }
    
    @PutMapping("/{id}")
    public Producto actualizarProducto(@PathVariable int id, @RequestBody Producto productoActualizado){
        for(int i = 0; i< productos.size(); i++){
            if(productos.get(i).getId() == id){
                productos.set(i, productoActualizado);
                return productoActualizado;
            }
        }
        return null;
    }

    @PatchMapping("/{id}")
    public Producto updateProducto(@PathVariable int id, @RequestBody Map<String, Object> cambios){
        for(Producto p : productos){
            if(p.getId() == id){
                if(cambios.containsKey("nombre"))
                    p.setNombre((String) cambios.get("nombre"));

                if(cambios.containsKey("precio"))
                    p.setPrecio(Double.valueOf(cambios.get("precio").toString()));

                if(cambios.containsKey("categoria"))
                    p.setCategoria((String) cambios.get("categoria"));

                return p;
            }
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public String eliminarProducto(@PathVariable int id){
        productos.removeIf(p -> p.getId() == id);
        return "Producto eliminado";
    }
}
