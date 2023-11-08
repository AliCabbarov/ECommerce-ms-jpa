package repository;

import model.entity.Cart;
import model.entity.Product;

public interface CartRepository {
    void updateProductToCart(Cart cart);
    void buyProductsInCart(Cart cart);
}
