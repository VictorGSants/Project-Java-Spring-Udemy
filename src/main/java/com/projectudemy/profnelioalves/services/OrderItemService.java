package com.projectudemy.profnelioalves.services;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectudemy.profnelioalves.entities.OrderItem;
import com.projectudemy.profnelioalves.entities.PK.OrderItemPK;
import com.projectudemy.profnelioalves.repositories.OrderItemRepository;

@Service
public class OrderItemService {

    @Autowired
    private OrderItemRepository orderItemRepository;

    public List<OrderItem> findAll(){
        return orderItemRepository.findAll();
    }
    public OrderItem findById(OrderItemPK OrderItemPK){
        Optional<OrderItem> obj = orderItemRepository.findById(OrderItemPK);
        return obj.get();
    }
}



