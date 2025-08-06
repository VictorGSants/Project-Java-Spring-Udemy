package com.projectudemy.profnelioalves.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projectudemy.profnelioalves.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
    // This interface will automatically provide CRUD operations for Order entity
    // No additional methods are needed for basic operations    

}
