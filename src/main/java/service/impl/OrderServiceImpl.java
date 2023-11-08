package service.impl;

import model.entity.Order;
import model.entity.User;
import repository.OrderRepository;
import repository.impl.OrderRepositoryImpl;
import service.OrderService;

import java.time.LocalDateTime;

public class OrderServiceImpl implements OrderService {
    OrderRepository orderRepository = new OrderRepositoryImpl();
    @Override
    public void createOrder(User user) {
        Order order = Order.builder()
                .products(user.getCart().getProducts())
                .address(user.getAddress())
                .orderDate(LocalDateTime.now())
                .phone(user.getPhoneNumber())
                .totalPrice(user.getCart().getTotalAmount())
                .build();

//        System.out.println(order); FIXME delete this line

        orderRepository.createOrder(order);
    }

    @Override
    public void findAll() {
        System.out.println(orderRepository.findAll());;
    }
}
