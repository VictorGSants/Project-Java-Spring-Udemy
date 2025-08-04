package com.projectudemy.profnelioalves.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projectudemy.profnelioalves.entities.order;

public interface OrderRepository extends JpaRepository<order, Long> {
    // This interface will automatically provide CRUD operations for Order entity
    // No additional methods are needed for basic operations    

}
