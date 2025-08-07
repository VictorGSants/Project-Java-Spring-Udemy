package com.projectudemy.profnelioalves.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.projectudemy.profnelioalves.entities.User;
import com.projectudemy.profnelioalves.services.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



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
    @PostMapping
    public ResponseEntity <User> insert(@RequestBody User obj) {
        User newUser = userService.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newUser.getId()).toUri();
        
        // este método insere um novo usuário no banco de dados
        return ResponseEntity.created(uri).body(newUser);
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity <Void> delete (@PathVariable long id){
        userService.delete(id);
        return ResponseEntity.noContent().build();
        // este método deleta um usuário específico do banco de dados
    }
    
}
