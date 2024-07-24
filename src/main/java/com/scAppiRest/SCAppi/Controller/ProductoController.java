package com.scAppiRest.SCAppi.Controller;

import com.scAppiRest.SCAppi.Entities.Producto;
import com.scAppiRest.SCAppi.Repositories.ProductoRepository;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoRepository productoRepository;

    @GetMapping
    public List<Producto> getAllProductos(){
        return productoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Producto getProductById(@PathVariable Long  id){
        return productoRepository.findById(id)
        .orElseThrow(()-> new RuntimeException("No se encontro el producto con el ID: " + id));
    }


    @PostMapping
    public Producto createProducto(@RequestBody Producto producto){
        return productoRepository.save(producto);
    }


    @PutMapping("/{id}")
    public Producto updateProducto(@PathVariable Long  id, @RequestBody Producto detailsProduct){
        Producto producto = productoRepository.findById(id)
        .orElseThrow(()-> new RuntimeException("No se encontro el producto con el ID: " + id));

        producto.setNombre(detailsProduct.getNombre());
        producto.setPrecio(detailsProduct.getPrecio());

        return productoRepository.save(producto);
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Long  id){
        Producto producto = productoRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("No se encontro el producto con el ID: " + id));
        productoRepository.delete(producto);
        return "El producto conel ID: " + id + " fue eliminado satisfactoriamente";
    }

}
