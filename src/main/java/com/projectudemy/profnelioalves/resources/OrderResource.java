package com.projectudemy.profnelioalves.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projectudemy.profnelioalves.entities.order;
import com.projectudemy.profnelioalves.services.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
;


@RestController
@RequestMapping(value = "/orders")

public class OrderResource {

    @Autowired
    // This annotation injects the OrderService bean into this resource
    private OrderService orderService;

    @GetMapping()
    public ResponseEntity <List<order>> findAll() {
        List<order> list = orderService.findAll();
        // This method retrieves all orders from the service
        return ResponseEntity.ok().body(list);
        // This returns a response entity with the list of orders in JSON format
    }   
    @GetMapping("/{id}")
    // This method retrieves a specific order by its ID
    public ResponseEntity<order> findById(@PathVariable long id){
        order order = orderService.findById(id);
        return ResponseEntity.ok().body(order);

    }
    

}
