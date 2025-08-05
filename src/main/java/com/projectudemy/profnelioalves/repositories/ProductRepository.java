package com.projectudemy.profnelioalves.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import com.projectudemy.profnelioalves.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    // This interface will automatically provide CRUD operations for Product entity
    // No additional methods are needed for basic operations

}
