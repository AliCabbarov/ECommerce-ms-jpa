package service;

import model.entity.User;

import java.math.BigDecimal;
import java.util.List;

public interface UserService {
    void showAllProduct();
    void addProductToCart(User user);
    void deleteProductToCart(User user);
    void buyProductToCart(User user);
    void increaseBalance(User user);
    List<User> findAll();
    void createUser(User user);
    void updateAccount(User user,BigDecimal price);
}

