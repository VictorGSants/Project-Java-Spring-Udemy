package com.projectudemy.profnelioalves.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projectudemy.profnelioalves.entities.User;

public interface UserRepositoriy extends JpaRepository <User, Long> {
    // This interface will automatically provide CRUD operations for User entity
    // No additional methods are needed for basic operations

}
