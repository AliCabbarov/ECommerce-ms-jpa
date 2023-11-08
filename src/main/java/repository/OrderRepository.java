package repository;

import model.entity.Order;

import java.util.List;

public interface OrderRepository {
    void createOrder(Order order);
    List<Order> findAll();
}
