package com.projectudemy.profnelioalves.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import com.projectudemy.profnelioalves.services.ProductService;
import com.projectudemy.profnelioalves.entities.Product;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


// Expõe endpoints REST para o cliente (ex: um app ou front-end).
//

@Service
@RestController
@RequestMapping(value = "/products")
public class ProductResource {
    
   @Autowired
    private ProductService productService;

    
    @GetMapping()
    public ResponseEntity <List<Product>> findAll() {
        List <Product> list = productService.findAll();
        return ResponseEntity.ok().body(list);
        }

    @GetMapping("/{id}")
    public ResponseEntity <Product> findById(@PathVariable Long id) {
       Product obj = productService.findById(id);
        return ResponseEntity.ok().body(obj);

    }
}

           
 


