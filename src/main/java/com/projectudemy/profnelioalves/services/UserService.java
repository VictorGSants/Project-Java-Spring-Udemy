package com.projectudemy.profnelioalves.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectudemy.profnelioalves.entities.User;
import com.projectudemy.profnelioalves.repositories.UserRepositoriy;
import com.projectudemy.profnelioalves.services.exceptions.ResourceNotFoundException;

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
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
        // esse método busca um usuário pelo ID
    }
    public User insert(User obj){
        return userRepositoriy.save(obj);
        // esse método insere um novo usuário no banco de dados
        // o método save() é herdado da interface JpaRepository
        // e o Spring Data JPA cuida de gerar a consulta SQL
        // para inserir o usuário no banco de dados
    }
    public void delete(Long id){
        userRepositoriy.deleteById(id);
        // esse método deleta um usuário pelo ID
        // o método deleteById() é herdado da interface JpaRepository
        // e o Spring Data JPA cuida de gerar a consulta SQL
        // para deletar o usuário do banco de dados
    }
    public User update(Long id, User obj){
        User entity = userRepositoriy.getReferenceById(id);
        updateData(entity, obj);
        return userRepositoriy.save(entity);
    }
    private void updateData(User entity, User obj) {
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setPhone(obj.getPhone());

    }
    
}
