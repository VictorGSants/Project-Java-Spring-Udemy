package com.projectudemy.profnelioalves.services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectudemy.profnelioalves.entities.Order;
import com.projectudemy.profnelioalves.repositories.OrderRepository;

@Service
public class OrderService {
    // This class will contain methods to handle business logic related to orders
    // For now, it is empty but can be expanded later with methods like findAll, findById, etc.
   
    @Autowired
    OrderRepository orderRepository;

    public List<Order> findAll() {
        return orderRepository.findAll();
    }
    public Order findById(long id){
        Optional<Order> obj = orderRepository.findById(id);
        return obj.get();
    }
}
