package com.projectudemy.profnelioalves.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.projectudemy.profnelioalves.entities.OrderItem;
import com.projectudemy.profnelioalves.entities.PK.OrderItemPK;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {
    // This interface will automatically provide CRUD operations for OrderItem entity
    // No additional methods are needed for basic operations>{

}
