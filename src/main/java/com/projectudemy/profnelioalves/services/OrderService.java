package com.projectudemy.profnelioalves.services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectudemy.profnelioalves.entities.order;
import com.projectudemy.profnelioalves.repositories.OrderRepository;

@Service
public class OrderService {
    // This class will contain methods to handle business logic related to orders
    // For now, it is empty but can be expanded later with methods like findAll, findById, etc.
   
    @Autowired
    OrderRepository orderRepository;

    public List<order> findAll() {
        return orderRepository.findAll();
    }
    public order findById(long id){
        Optional<order> obj = orderRepository.findById(id);
        return obj.get();
    }
}
