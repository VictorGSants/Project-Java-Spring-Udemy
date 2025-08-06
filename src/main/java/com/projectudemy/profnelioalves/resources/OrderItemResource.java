package com.projectudemy.profnelioalves.resources;

import org.springframework.beans.factory.annotation.Autowired;

import jakarta.annotation.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

import com.projectudemy.profnelioalves.services.OrderItemService;
import com.projectudemy.profnelioalves.entities.OrderItem;
import com.projectudemy.profnelioalves.entities.PK.OrderItemPK;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@Resource
@RestController
@RequestMapping("/orderItems")
public class OrderItemResource {

    @Autowired
    private OrderItemService orderItemService;

    @GetMapping()
    public ResponseEntity<List<OrderItem>> findAll() {
        List<OrderItem> list = orderItemService.findAll();
        return ResponseEntity.ok().body(list);
    }
    @GetMapping("/{id}")
    public ResponseEntity <OrderItem> findById(@PathVariable OrderItemPK id){
        OrderItem obj = orderItemService.findById(id);
        return ResponseEntity.ok().body(obj);
    }


}
