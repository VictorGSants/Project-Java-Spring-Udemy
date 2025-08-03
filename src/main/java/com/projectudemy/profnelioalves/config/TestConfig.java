package com.projectudemy.profnelioalves.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.projectudemy.profnelioalves.entities.User;
import com.projectudemy.profnelioalves.repositories.UserRepositoriy;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
    // This class can be used to define beans or configurations specific to the test profile
    // For example, you might want to set up an in-memory database or mock services here
    // Currently, it is empty but can be extended as needed for testing purposes
    @Autowired
    private UserRepositoriy userRepositoriy;

    // tudo que colocar aqui vai ser executado quando o perfil de teste for ativado
    // Isso é útil para popular o banco de dados com dados de teste ou configurar mocks
    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456"); 

        userRepositoriy.saveAll(Arrays.asList(u1, u2));
        // Aqui, estamos salvando dois usuários no repositório de usuários
        
    }
}
