package service.impl;

import model.entity.Cart;
import model.entity.Product;
import model.entity.User;
import repository.CartRepository;
import repository.impl.CartRepositoryImpl;
import service.CartService;

import java.math.BigDecimal;
import java.util.ArrayList;

public class CartServiceImpl implements CartService {
    CartRepository cartRepository = new CartRepositoryImpl();
    @Override
    public void buyProductsInCart(Cart cart) {
        cart.setProducts(new ArrayList<>());
        cart.setCount(0);
        cart.setTotalAmount(new BigDecimal(0));
        cartRepository.buyProductsInCart(cart);
    }

    @Override
    public void addProductToCart(Cart cart, Product product) {
        cart.addProducts(product);

        cart.setCount(cart.getProducts().size());

        BigDecimal totalAmount = cart.sumProductPrice(cart.getProducts());

        cart.setTotalAmount(totalAmount);

        cartRepository.updateProductToCart(cart);
    }

    @Override
    public void deleteProductToCart(Cart cart, Product product) {
        cart.deleteProducts(product);

        cart.setCount(cart.getProducts().size());

        BigDecimal totalAmount = cart.sumProductPrice(cart.getProducts());

        cart.setTotalAmount(totalAmount);

        cartRepository.updateProductToCart(cart);
    }

    @Override
    public void showAllProductInCart(User user) {
        System.out.println(user.getCart().getProducts());

    }

}
