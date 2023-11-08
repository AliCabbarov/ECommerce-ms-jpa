package service;

import model.entity.Cart;
import model.entity.Product;
import model.entity.User;

public interface CartService {

    void buyProductsInCart(Cart cart);
    void addProductToCart(Cart cart, Product product);
    void deleteProductToCart(Cart cart,Product product);
    void showAllProductInCart(User user);

}
