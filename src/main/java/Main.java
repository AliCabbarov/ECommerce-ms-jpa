import controller.Management;
import controller.impl.ManagementImpl;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import model.entity.Order;
import repository.OrderRepository;
import repository.ProductRepository;
import repository.impl.OrderRepositoryImpl;
import repository.impl.ProductRepositoryImpl;

import java.time.LocalDate;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        new ManagementImpl().manage();
//        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("postgres");
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        EntityTransaction entityTransaction = entityManager.getTransaction();
//
//        entityTransaction.begin();
//
//
//
//        entityTransaction.commit();

//        System.out.println(LocalDate.now());
//        ProductRepository productRepository = new ProductRepositoryImpl();
//
//
//        Order order = Order.builder()
//                .address("baku")
//                .products(List.of(productRepository.findById(7).get()))
//                .build()    ;
//        System.out.println(order);
//
//        OrderRepository orderRepository = new OrderRepositoryImpl();
//        orderRepository.createOrder(order);
    }





}
