package com.projectudemy.profnelioalves.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectudemy.profnelioalves.entities.User;
import com.projectudemy.profnelioalves.repositories.UserRepositoriy;

@Service
public class UserService {
    
    @Autowired
    private UserRepositoriy userRepositoriy;

    public List<User> findAll(){
        return userRepositoriy.findAll();
        // esse método retorna uma lista de usuários do banco de dados
        // não é necessário fazer nada a mais, o Spring Data JPA cuida disso
        // automaticamente 
        //
        // o método findAll() é herdado da interface JpaRepository
        // que já implementa os métodos CRUD (Create, Read, Update, Delete)
        // e o Spring Data JPA gera a implementação automaticamente
        // então, não precisamos escrever nenhuma consulta SQL
        // ou JPQL, o Spring Data JPA faz isso por nós
        // e retorna uma lista de objetos User
        // que será convertida em JSON pelo Spring Boot
        // e retornada para o cliente que fez a requisição
    }
    public User findById(long id){
        Optional<User> obj = userRepositoriy.findById(id);
        return obj.get();
        // esse método busca um usuário pelo ID
        
    }
    
}
