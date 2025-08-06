package com.projectudemy.profnelioalves.config;



import java.util.Arrays;
import java.time.Instant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.projectudemy.profnelioalves.entities.Order;
import com.projectudemy.profnelioalves.entities.User;
import com.projectudemy.profnelioalves.repositories.UserRepositoriy;
import com.projectudemy.profnelioalves.repositories.CategoryRepository;
import com.projectudemy.profnelioalves.repositories.OrderRepository;
import com.projectudemy.profnelioalves.repositories.ProductRepository;
import com.projectudemy.profnelioalves.entities.Category;
import com.projectudemy.profnelioalves.entities.OrderItem;
import com.projectudemy.profnelioalves.entities.Payment;
import com.projectudemy.profnelioalves.entities.Product;
import com.projectudemy.profnelioalves.entities.enuns.OrderStatus;
import com.projectudemy.profnelioalves.repositories.OrderItemRepository;


@Configuration
@Profile("test")
public class TestConfig<Z> implements CommandLineRunner{
    // This class can be used to define beans or configurations specific to the test profile
    // For example, you might want to set up an in-memory database or mock services here
    // Currently, it is empty but can be extended as needed for testing purposes
    @Autowired
    private UserRepositoriy userRepositoriy;

    @Autowired
    private OrderRepository orderRepository;
    
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;


    // tudo que colocar aqui vai ser executado quando o perfil de teste for ativado
    // Isso é útil para popular o banco de dados com dados de teste ou configurar mocks
    @Override
    public void run(String... args) throws Exception {
        // Aqui, estamos criando alguns usuários e pedidos de exemplo para serem usados nos testes
        // Esses dados serão inseridos no banco de dados quando o perfil de teste for ativado

        Category cat1 = new Category(null, "Electronics");
        Category cat2 = new Category(null, "Books");
        Category cat3 = new Category(null, "Computers");

       

        Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
        Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
        Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
        Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
        Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, ""); 

        categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

        p1.getCategories().add(cat2);
        p2.getCategories().add(cat1);
        p2.getCategories().add(cat3);
        p3.getCategories().add(cat3);
        p4.getCategories().add(cat1);
        p4.getCategories().add(cat3);
        p5.getCategories().add(cat2);   

        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456"); 

        Order o1 = new Order(null, Instant.parse("2019-07-20T19:53:07Z"), OrderStatus.SHIPPED, u1);
        // This creates a new order with a specific date and associates it with user u1
        Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, u2);
        Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.DELIVERED, u1);

        userRepositoriy.saveAll(Arrays.asList(u1, u2));
        // Aqui, estamos salvando dois usuários no repositório de usuários
        orderRepository.saveAll(Arrays.asList(o1, o2, o3));

        OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
        OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice());
        OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice());
        OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPrice());
        
        orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));
        // Aqui, estamos criando itens de pedido (OrderItem) que associam pedidos a produtos

        Payment pay1 = new Payment(null, Instant.parse("2019-07-21T22:53:07Z"), o1);
        o1.setPayment(pay1);
        orderRepository.save(o1);
        
    }
    
}
