package com.projectudemy.profnelioalves.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projectudemy.profnelioalves.entities.User;
import com.projectudemy.profnelioalves.services.UserService;

@RestController
@RequestMapping("/users")
public class UserResource {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        List <User> list = userService.findAll();
        return ResponseEntity.ok().body(list);
        // este método retorna uma lista de usuários em formato JSON
    }
    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable long id){
        User user = userService.findById(id);
        // este método retorna um usuário específico em formato JSON
        return ResponseEntity.ok().body(user);
        // se o usuário for encontrado, retorna o usuário
    }
    
}
