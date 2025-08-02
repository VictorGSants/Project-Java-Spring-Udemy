package com.projectudemy.profnelioalves.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projectudemy.profnelioalves.entities.User;

@RestController
@RequestMapping("/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<User> findAll() {
        User user = new User(1L, "Nelio Alves", "nelio@gmail.com", "123456", "9999-9999");
        return ResponseEntity.ok().body(user);
    }
    
}
