package service;

import model.entity.Order;
import model.entity.User;

public interface OrderService {
    void createOrder(User user);
    void findAll();
}
