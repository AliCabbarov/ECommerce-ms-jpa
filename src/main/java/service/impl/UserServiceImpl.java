package service.impl;

import helper.ServiceHelper;
import model.entity.Cart;
import model.entity.Product;
import model.entity.User;
import model.enums.ExceptionEnums;
import model.exception.ApplicationException;
import repository.UserRepository;
import repository.impl.UserRepositoryImpl;
import service.*;
import util.InputUtil;

import java.math.BigDecimal;
import java.util.List;

import static model.constant.Constant.*;

public class UserServiceImpl implements UserService {
    ProductService productService = new ProductServiceImpl();
    CompanyService companyService = new CompanyServiceImpl();
    OrderService orderService = new OrderServiceImpl();
    CartService cartService = new CartServiceImpl();
    UserRepository userRepository = new UserRepositoryImpl();

    @Override
    public void showAllProduct() {
        productService.showAllProduct();
    }

    @Override
    public void addProductToCart(User user) {
        showAllProduct();

        Product product = productService.findById(ADD, false);

        Cart cart = user.getCart();

        cartService.addProductToCart(cart, product);

    }

    @Override
    public void deleteProductToCart(User user) {
        if (user.getCart().getProducts().isEmpty()) {
            throw new ApplicationException(ExceptionEnums.PRODUCT_HAS_NOT_BEEN_SELECTED);
        }
        cartService.showAllProductInCart(user);

        Product product = productService.findById(DELETE, false);
        Cart cart = user.getCart();

        cartService.deleteProductToCart(cart, product);

    }

    @Override
    public void buyProductToCart(User user) {
        if (user.getCart().getProducts().isEmpty()) {
            throw new ApplicationException(ExceptionEnums.PRODUCT_HAS_NOT_BEEN_SELECTED);
        }

        Cart cart = user.getCart();

        ServiceHelper.checkUserAccount(user, cart.getTotalAmount());


        cartService.showAllProductInCart(user);

        try {
            Product product = productService.findById(COMMENT_AND_STARS, false);

            String comment = InputUtil.getInstance().inputString("comment: ");
            byte star = Byte.parseByte(InputUtil.getInstance().inputString("Enter star point: "));


            productService.updateProduct(product, comment, star);

        } catch (RuntimeException e) {
            e.printStackTrace();
        }


        productService.decreaseRemainCount(cart.getProducts());

        companyService.updateAccountCompany(cart.getTotalAmount());

        updateAccount(user, cart.getTotalAmount());

        orderService.createOrder(user);

        cartService.buyProductsInCart(cart);
        System.out.println(BUYING_SUCCESSFULLY);
    }

    @Override
    public void increaseBalance(User user) {
        BigDecimal balance = BigDecimal.valueOf(Long.parseLong(InputUtil.getInstance().inputString("Enter the increase balance: ")));
        user.setAccount(user.getAccount().add(balance));

    }

    @Override
    public List<User> findAll() {

        return userRepository.findAll();
    }

    @Override
    public void createUser(User user) {
        userRepository.saveUser(user);
    }

    @Override
    public void updateAccount(User user, BigDecimal price) {
        user.setAccount(user.getAccount().subtract(price));
        userRepository.updateUser(user);
    }
}
